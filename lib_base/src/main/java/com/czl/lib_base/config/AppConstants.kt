package com.czl.lib_base.config

/**
 * @author Alwyn
 * @Date 2020/10/22
 * @Description 常量管理类
 */
interface AppConstants {
    object SpKey {
        const val LOGIN_NAME: String = "login_name"
        const val USER_ID: String = "user_id"
        const val SEARCH_HISTORY: String = "search_history"
        const val USER_JSON_DATA: String = "user_json_data"
    }

    /**
     * value规则： /(module后缀)/(所在类名)
     * 路由 A_ : Activity
     *     F_ : Fragment
     */
    interface Router {
        object Web {
            const val F_WEB = "/web/WebFragment"
        }
        object Main {
            const val A_TEST = "/main/TestActivity"
            const val A_MAIN = "/main/MainActivity"
            const val F_HOME = "/main/HomeFragment"
        }

        object Login {
            const val F_LOGIN = "/login/LoginFragment"
            const val F_REGISTER = "/login/RegisterFragment"
        }

        object User {
            const val F_FIRST = "/user/FirstFragment"
            const val F_USER = "/user/UserFragment"
            const val F_USER_SCORE = "/user/UserScoreFragment"
            const val F_USER_RANK = "/user/UserRankFragment"
            const val F_USER_COLLECT = "/user/UserCollectFragment"
            const val F_USER_SHARE = "/user/UserShareFragment"
        }

        object Square {
            const val F_SQUARE = "/square/SquareFragment"
            const val F_NAV = "/square/NavigateFragment"
            const val F_SYSTEM = "/square/SystemTreeFragment"
            const val F_SYS_DETAIL = "/square/SystemDetailFragment"
        }

        object Project {
            const val F_PROJECT = "/project/ProjectFragment"
        }

        object Search{
            const val F_SEARCH = "/search/SearchFragment"
        }
    }

    object BundleKey {
        const val MAIN2FIRST = "main2first"
        const val WEB_URL = "web_url"
        const val MAIN_SEARCH_KEYWORD = "main_search_keyword"
        const val USER_SCORE = "user_score"
        const val USER_RANK = "user_rank"
        const val WEB_URL_COLLECT_FLAG = "web_url_collect_flag"
        const val WEB_URL_ID = "web_url_id"
        const val SYSTEM_DETAIL = "system_detail"
        const val SYSTEM_DETAIL_POSITION = "system_detail_position"
    }
}