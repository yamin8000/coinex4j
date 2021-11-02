package com.github.TradersTeam.coinex4j;

import com.github.TradersTeam.coinex4j.network.CoinEx4J;
import com.github.TradersTeam.coinex4j.network.apis.PerpetualAPIs;

public class Console {
    public static void main(String... args) {
        CoinEx4J coinEx4J = new CoinEx4J.Builder()
                .createDefaultInstance()
                .autoShutDown(true)
                .build();

        var call = coinEx4J.createAPI(PerpetualAPIs.class).getMarketList();
        call.asyncBody(coinEx4J, (response, throwable) -> {
            if (response != null && throwable == null) {
                System.out.println(response.data());
            } else {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
