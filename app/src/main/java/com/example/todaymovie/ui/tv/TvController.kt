package com.example.todaymovie.ui.tv

import androidx.fragment.app.Fragment
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.example.todaymovie.*
import com.example.todaymovie.domain.model.TV
import com.example.todaymovie.domain.model.TvHome
import com.example.todaymovie.ui.tv.banner.tvBanner
import com.example.todaymovie.util.px

class TvController(private val fragment: Fragment, private val onSeeMoreClick: ()-> Unit, private val onItemClick: (tv: TV) -> Unit): TypedEpoxyController<TvHome>() {
    override fun buildModels(data: TvHome?) {
        data?.let { data1->
            var id = -1

            tvBanner {
                id(id--)
                fragment(fragment)
                tvs(data1.trendingTv)
            }

            homeTitle {
                id(id--)
                title(fragment.requireContext().getString(R.string.popular_tv))
            }

            val popularCarouselItemModels = data1.popularTv?.map { tv ->
                TvBindingModel_()
                        .id(tv.id)
                        .tv(tv)
                        .clickListener { _ ->
                            onItemClick(tv)
                        }
            }
            popularCarouselItemModels?.let {
                carousel {
                    id(id--)
                    padding(Carousel.Padding(16.px, 16.px))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(popularCarouselItemModels)
                }
            }

            homeTitle {
                id(id--)
                title(fragment.requireContext().getString(R.string.airing_today_tv))
            }


            val airingTpdayCarouselItemModels = data1.airingTodayTv?.map { tv->
                TvBindingModel_()
                    .id(tv.id)
                    .tv(tv)
                    .clickListener{ _ ->
                        onItemClick(tv)
                    }
            }

            airingTpdayCarouselItemModels?.let {
                carousel {
                    id(id--)
                    padding(Carousel.Padding(16.px, 16.px))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(airingTpdayCarouselItemModels)
                }
            }

            homeTitle {
                id(id--)
                title(fragment.requireContext().getString(R.string.top_rated_movie))
            }

            val topRatedCarouselItemModels = data1.topRateTv?.map { tv->
                TvBindingModel_()
                    .id(tv.id)
                    .tv(tv)
                    .clickListener{ _ ->
                        onItemClick(tv)
                    }
            }

            topRatedCarouselItemModels?.let {
                carousel {
                    id(id--)
                    padding(Carousel.Padding(16.px, 16.px))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(topRatedCarouselItemModels)
                }
            }

            homeTitle {
                id(id--)
                title(fragment.requireContext().getString(R.string.on_the_air_tv))
            }

            val onTheAirCarouselItemModels = data1.onTheAirTv?.map { tv->
                TvBindingModel_()
                    .id(tv.id)
                    .tv(tv)
                    .clickListener{ _ ->
                        onItemClick(tv)
                    }
            }

            onTheAirCarouselItemModels?.let {
                carousel {
                    id(id--)
                    padding(Carousel.Padding(16.px, 16.px))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(onTheAirCarouselItemModels)
                }
            }
        }
    }
}