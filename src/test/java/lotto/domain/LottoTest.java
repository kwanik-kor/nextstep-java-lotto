package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또는")
    @Nested
    class Describe_constructor {

        @DisplayName("로또는 6개의 로또 번호를 생성자로 넘기면 Lotto를 생성한다.")
        @Test
        void it_returns_lotto() {
            final List<LottoNumber> numbers = IntStream.rangeClosed(1, 6)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());

            assertThatCode(() -> new Lotto(numbers))
                    .doesNotThrowAnyException();
        }

        @DisplayName("로또는 6개의 로또 번호를 생성자로 넘기지 않으면 IllegalArgumentException을 발생시킨다.")
        @Test
        void it_throws_illegalException_when_size_is_not_six() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Lotto(Collections.emptyList()));
        }

    }

}