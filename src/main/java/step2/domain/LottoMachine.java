package step2.domain;

import step2.strategy.LottoNumStrategy;

public class LottoMachine {

    private LottoNumStrategy strategy;

    private LottoMachine() {
    }

    private LottoMachine(LottoNumStrategy strategy) {
        this.strategy = strategy;
    }

    public static LottoMachine create() {
        return new LottoMachine();
    }

    public static LottoMachine of(LottoNumStrategy strategy) {
        return new LottoMachine(strategy);
    }

    public Lotto makeLotto() {
        return strategy.makeLotto();
    }

}