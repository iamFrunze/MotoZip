package com.byfrunze.motozip.content.search.providers

import com.byfrunze.motozip.content.search.models.TopFeedModel
import com.byfrunze.motozip.content.search.presenters.SearchMotorcyclePresenter

class SearchMotorcycleProvider(var presenter: SearchMotorcyclePresenter) {
    fun loadContent() {
        var listTopFeed: ArrayList<TopFeedModel> = ArrayList()
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        listTopFeed.add(TopFeedModel(img = "https://motoli.ru/uploads/posts/2016-12/thumbs/1483172951_2005-triumph-daytona650c.jpg",
                txt = "TEXT ONE"))
        presenter.contentLoaded(listTopFeed)

    }

}