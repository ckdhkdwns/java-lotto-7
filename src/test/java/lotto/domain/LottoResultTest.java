package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    @DisplayName("1등에 당첨된다.")
    @Test
    void 일등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));  // 1등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("2등에 당첨된다.")
    @Test
    void 이등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));  // 2등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("3등에 당첨된다.")
    @Test
    void 삼등에_당첨된다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));  // 3등

        LottoResult lottoResult = new LottoResult(List.of(lotto), winningLotto);

        assertThat(lottoResult.getCountByRank(Rank.THIRD)).isEqualTo(1);
    }
}