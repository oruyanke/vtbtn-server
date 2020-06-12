package com.oruyanke.vtbs

import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import org.koin.ktor.ext.inject
import org.litote.kmongo.coroutine.CoroutineClient


fun Route.statisticsRoute() {
    val mongo: CoroutineClient by inject()

    route("/statistics") {
        get("/{vtb}/statistic") {

        }
        get("/{vtb}/statistic/{group}") {

        }
        get("/{vtb}/statistic/{name}") {
            errorAware {
                val vtb = param("vtb")
                val group = param("group")
                val voiceName = param("name")

                val db = mongo.forVtuber(vtb)
                val voiceInfo = db.statistics()

            }
        }

        post("/{vtb}/statistic/{name}") {

        }

    }
}
