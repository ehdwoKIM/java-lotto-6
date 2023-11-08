package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.Exceptions;
import lotto.model.Customer;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
public class LottoService {
    Exceptions exceptions = new Exceptions();

    private static final int lottoStartNumber = 1;
    private static final int lottoStopNumber = 45;
    private static final int lottoLength = 6;

    public void buyLottoByTicket(Customer customer) {
        int ticket = buyLottoTicket(customer.getPurchaseMoney());
        for (int i = ticket; i > 0; i--) {
            buyOneLotto(customer);
        }
    }

    private int buyLottoTicket(int money) {
        exceptions.isInvalidPurchaseMoneyAmount(money, 1000);
        int lottoTicket = money / 1000;
        return lottoTicket;
    }

    private void buyOneLotto(Customer customer) {
        Lotto lotto = generateLottoNumber();
        customer.buyLotto(lotto);
    }

    private Lotto generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>(lottoNumberGenerator(lottoStartNumber, lottoStopNumber, lottoLength));
        return new Lotto(numbers);
    }

    private List<Integer> lottoNumberGenerator(int start, int end, int length) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, length);
        return numbers;
    }
}
