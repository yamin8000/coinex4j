package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface PerpetualAPIs {
    String PERPETUAL_V1 = "perpetual/v1/";
    String MARKET = "market/";

    interface System {
        @GET(PERPETUAL_V1 + "ping")
        Call<ApiResponse<String>> getPing();

        @GET(PERPETUAL_V1 + "time")
        Call<ApiResponse<DateTime>> getTime();
    }

    @GET(PERPETUAL_V1 + MARKET + "list")
    Call<ApiResponse<List<Market>>> getMarketList();

    @GET(PERPETUAL_V1 + MARKET + "limit_config")
    Call<ApiResponse<Map<String, List<LimitConfig>>>> getMarketLimitConfigList();

    @GET(PERPETUAL_V1 + MARKET + "ticker")
    Call<ApiResponse<MarketTicker>> getMarketTicker(@Query("market") String market);

    @GET(PERPETUAL_V1 + MARKET + "ticker" + "/all")
    Call<ApiResponse<MarketTickers>> getMarketTickers();

    @GET(PERPETUAL_V1 + MARKET + "depth")
    Call<ApiResponse<MarketDepth>> getMarketDepth(
            @Query("market") String market, @Query("merge") Double merge, @Query("limit") int limit
    );
}
