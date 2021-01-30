package lotto.domain;

import lotto.dto.BuyerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {

    @DisplayName("가지고 있는 티켓 카운트에 따라서 구매 여부를 잘 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({
        "1, true",
        "0, false",
    })
    void canBuyTicket(int ticketCnt, boolean buyStatus) {
        LottoBuyer buyer = new LottoBuyer(ticketCnt);
        assertEquals(buyer.canBuyTicket(), buyStatus);
    }

    @DisplayName("티켓 구매 후, 구매 가능 횟수가 잘 줄었는지 확인")
    @Test
    void buyTicket() {
        LottoBuyer buyer = new LottoBuyer(1);

        buyer.buyTicket();

        assertEquals(buyer, new LottoBuyer(0));
    }

    @DisplayName("티켓 구매자의 정보 데이터를 잘 가져오는지 확인")
    @Test
    void getBuyerData() {
        LottoBuyer buyer = new LottoBuyer(1);

        assertEquals(buyer.getBuyerData(), new BuyerData(1));
    }
}