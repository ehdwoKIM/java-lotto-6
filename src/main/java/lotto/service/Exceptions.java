package lotto.service;

public class Exceptions {
    public void isInvalidPurchaseMoneyAmount(int money, int divided){
        if(money % divided != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원단위로 가능합니다.");
        }
    }

    public void isInvalidNumberOfLotteries(String input){
        String[] lotteries  = input.split(",");
        if(lotteries.length != 6){
            throw new IllegalArgumentException("로또 번호는 6개를 입력해야 합니다.");
        }
    }

    public void isInvalidNumberOfBonusNumber(String bonus){
        try {
            int bonusNumber = Integer.parseInt(bonus);
            if(bonusNumber <= 1 || bonusNumber >= 45){
                throw new IllegalArgumentException("보너스 번호는 1 ~ 45까지 입력 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다.");
        }
    }
}
