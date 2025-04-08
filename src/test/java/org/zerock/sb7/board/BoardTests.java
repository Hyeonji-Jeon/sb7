package org.zerock.sb7.board;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.sb7.board.repo.BoardRepo;
import org.zerock.sb7.board.repo.FavoriteRepo;
import org.zerock.sb7.board.repo.ReplyRepo;

import java.util.Arrays;

@SpringBootTest
@Log4j2
public class BoardTests {

    @Autowired
    private BoardRepo boardRepo;
    @Autowired
    private ReplyRepo replyRepo;
    @Autowired
    private FavoriteRepo favoriteRepo;

    @Test
    public void testListGrouping() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Object[]> result = boardRepo.list1(pageable);

        result.forEach(arr -> log.info(Arrays.toString(arr)));

    }


}