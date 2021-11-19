package com.surendra.jd_test.repository

import com.surendra.jd_test.model.RootResponse
import com.surendra.jd_test.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface JDDataService {

    @GET(END_POINT)
    suspend fun getNavData(): Response<RootResponse>

}