package com.surendra.jd_test.repository

import com.surendra.jd_test.model.RootResponse
import retrofit2.Response
import javax.inject.Inject

class JDRepository
@Inject
constructor(private val api: JDDataService) {

    suspend fun getNavData(): Response<RootResponse> = api.getNavData()

}