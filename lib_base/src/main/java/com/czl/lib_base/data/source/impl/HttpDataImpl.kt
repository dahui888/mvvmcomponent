package com.czl.lib_base.data.source.impl

import com.czl.lib_base.base.BaseBean
import com.czl.lib_base.data.api.ApiService
import com.czl.lib_base.data.bean.*
import com.czl.lib_base.data.source.HttpDataSource
import io.reactivex.Observable

/**
 * @author Alwyn
 * @Date 2020/7/22
 * @Description
 */
class HttpDataImpl(private val apiService: ApiService) : HttpDataSource {

//    companion object {
//        @Volatile
//        private var INSTANCE: HttpDataImpl? = null
//        fun getInstance(demoApiService: DemoApiService): HttpDataImpl? {
//            if (INSTANCE == null) {
//                synchronized(HttpDataImpl::class.java) {
//                    if (INSTANCE == null) {
//                        INSTANCE = HttpDataImpl(demoApiService)
//                    }
//                }
//            }
//            return INSTANCE
//        }
//    }

    override fun userLogin(account: String, pwd: String): Observable<BaseBean<UserBean>> {
        return apiService.pwdLogin(account,pwd)
    }


    override fun getMainArticle(page: String): Observable<BaseBean<ArticleBean>> {
        return apiService.getMainArticle(page)
    }

    override fun getCollectArticle(page: String): Observable<BaseBean<CollectArticleBean>> {
        return apiService.getCollectArticle(page)
    }

    override fun getBannerData(): Observable<BaseBean<List<HomeBannerBean>>> {
        return apiService.getBannerData()
    }

    override fun getHomeArticle(page: String): Observable<BaseBean<HomeArticleBean>> {
        return apiService.getHomeArticle(page)
    }

    override fun getHomeProject(page: String): Observable<BaseBean<ProjectBean>> {
        return apiService.getHomeProject(page)
    }

    override fun collectArticle(articleId: Int): Observable<BaseBean<Any?>> {
        return apiService.collectArticle(articleId)
    }

    override fun unCollectArticle(articleId: Int): Observable<BaseBean<Any?>> {
        return apiService.unCollectArticle(articleId)
    }

    override fun unCollectArticle(id: Int, originId: Int): Observable<BaseBean<Any?>> {
        return apiService.unCollectArticle(id,originId)
    }

    override fun logout(): Observable<BaseBean<Any?>> {
        return apiService.logout()
    }

    override fun register(
        username: String,
        password: String,
        repassword: String
    ): Observable<BaseBean<Any?>> {
        return apiService.register(username,password,repassword)
    }

    override fun searchByKeyword(
        page: String,
        keyword: String
    ): Observable<BaseBean<SearchDataBean>> {
        return apiService.searchByKeyword(page,keyword)
    }

    override fun getSearchHotKey(): Observable<BaseBean<List<SearchHotKeyBean>>> {
        return apiService.getSearchHotKey()
    }

    override fun getProjectSort(): Observable<BaseBean<List<ProjectSortBean>>> {
        return apiService.getProjectSort()
    }

    override fun getProjectByCid(page: String, cid: String): Observable<BaseBean<ProjectBean>> {
        return apiService.getProjectByCid(page,cid)
    }

    override fun getUserShareData(page: String): Observable<BaseBean<UserShareBean>> {
        return apiService.getUserShareData(page)
    }

    override fun getUserScoreDetail(page: String): Observable<BaseBean<UserScoreDetailBean>> {
        return apiService.getUserScoreDetail(page)
    }

    override fun getUserScore(): Observable<BaseBean<UserScoreBean>> {
        return apiService.getUserScore()
    }

    override fun getScoreRank(page: String): Observable<BaseBean<UserRankBean>> {
        return apiService.getScoreRank(page)
    }

    override fun getUserCollectWebsite(): Observable<BaseBean<List<CollectWebsiteBean>>> {
        return apiService.getUserCollectWebsite()
    }

    override fun deleteUserCollectWeb(id: String): Observable<BaseBean<Any?>> {
        return apiService.deleteUserCollectWeb(id)
    }

    override fun collectWebsite(name: String, link: String): Observable<BaseBean<Any?>> {
        return apiService.collectWebsite(name,link)
    }

    override fun getSquareList(page: Int): Observable<BaseBean<SquareListBean>> {
        return apiService.getSquareList(page)
    }

    override fun getSystemTreeData(): Observable<BaseBean<List<SystemTreeBean>>> {
        return apiService.getSystemTreeData()
    }

    override fun getNavData(): Observable<BaseBean<List<NavigationBean>>> {
        return apiService.getNavData()
    }

    override fun getArticlesByCid(page: Int, cid: String): Observable<BaseBean<SystemDetailBean>> {
        return apiService.getArticlesByCid(page,cid)
    }

    override fun shareArticleToSquare(title: String, link: String): Observable<BaseBean<Any?>> {
        return apiService.shareArticleToSquare(title,link)
    }

    override fun deleteArticleById(id: Int): Observable<BaseBean<Any?>> {
        return apiService.deleteArticleById(id)
    }

    override fun getShareUserDetail(
        uid: String,
        page: Int
    ): Observable<BaseBean<ShareUserDetailBean>> {
        return apiService.getShareUserDetail(uid,page)
    }

}