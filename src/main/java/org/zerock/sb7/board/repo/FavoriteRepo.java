package org.zerock.sb7.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.sb7.board.domain.Board;

public interface FavoriteRepo extends JpaRepository<Board, Integer> {
}
