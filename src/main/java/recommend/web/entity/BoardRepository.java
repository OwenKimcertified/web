package recommend.web.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // update board_table set board_hits = board_hits += 1 where id = ?
    @Modifying // 필수
    @Query(value = "update BoardEntity as b set b.boardHits = b.boardHits + 1 where b.id = :id") // entity 기준으로 DB 기준 아님
    void updateHits(@Param("id") Long id);

}
