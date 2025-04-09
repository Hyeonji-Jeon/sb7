package org.zerock.sb7.board.repo.search;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.zerock.sb7.board.domain.*;

@Log4j2
@RequiredArgsConstructor
public class BoardSearchImpl implements BoardSearch {

    private final JPQLQueryFactory queryFactory;

    @Override
    public void search() {

        log.info("--------------------------");
        log.info("Searching for boards");

        int limit = 10;
        int offset = 0;

        QBoard board = QBoard.board;
        QFavorite favorite = QFavorite.favorite;
        QBoardImage boardImage = QBoardImage.boardImage;

        JPQLQuery<Board> query = queryFactory.selectFrom(board);
        query.leftJoin(board.images, boardImage);
        query.leftJoin(favorite).on(favorite.board.eq(board));

        query.where(favorite.choice.eq(Choice.LIKE));
        query.where(boardImage.ord.eq(0));
        query.groupBy(board);

        query.limit(limit);
        query.offset(offset);
        query.orderBy(new OrderSpecifier<>(Order.DESC, board.bno));

        log.info("--------------------------");
        log.info(query);

        query.fetch();

    }
}
