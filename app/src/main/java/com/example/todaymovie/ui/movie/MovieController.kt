package com.example.todaymovie.ui.movie

import androidx.fragment.app.Fragment
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.example.todaymovie.HomeTitleBindingModel_
import com.example.todaymovie.MovieBindingModel_
import com.example.todaymovie.R
import com.example.todaymovie.domain.model.Movie
import com.example.todaymovie.domain.model.MovieHome
import com.example.todaymovie.ui.movie.banner.movieBanner
import com.example.todaymovie.util.px

class MovieController(private val fragment: Fragment, private val onSeeMoreClick: ()-> Unit, private val onItemClick: (movie: Movie) -> Unit): TypedEpoxyController<MovieHome>() {
    override fun buildModels(data: MovieHome?) {
        data?.let { data1->
            var id = -1
            movieBanner {
                id(id--)
                fragment(fragment)
                movies(data1.trendingMovies)
            }

            HomeTitleBindingModel_()
                .id(id--)
                .title(fragment.requireContext().getString(R.string.popular_movie))
                .addTo(this)

            val popularCarouselItemModels = data1.popularMovies?.map { movie->
                MovieBindingModel_()
                    .id(movie.id)
                    .movie(movie)
                    .clickListener{ _ ->
                        onItemClick(movie)
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


            HomeTitleBindingModel_()
                .id(id--)
                .title(fragment.requireContext().getString(R.string.now_playing_movie))
                .addTo(this)

            val nowPlayingCarouselItemModels = data1.nowPlayingMovies?.map { movie->
                MovieBindingModel_()
                    .id(movie.id)
                    .movie(movie)
                    .clickListener{ _ ->
                        onItemClick(movie)
                    }
            }

            nowPlayingCarouselItemModels?.let {
                carousel {
                    id(id--)
                    padding(Carousel.Padding(16.px, 16.px))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(nowPlayingCarouselItemModels)
                }
            }

            HomeTitleBindingModel_()
                .id(id--)
                .title(fragment.requireContext().getString(R.string.top_rated_movie))
                .addTo(this)

            val topRatedCarouselItemModels = data1.topRateMovies?.map { movie->
                MovieBindingModel_()
                    .id(movie.id)
                    .movie(movie)
                    .clickListener{ _ ->
                        onItemClick(movie)
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

            HomeTitleBindingModel_()
                .id(id--)
                .title(fragment.requireContext().getString(R.string.upcoming_movie))
                .addTo(this)

            val upcomingCarouselItemModels = data1.upcomingMovies?.map { movie->
                MovieBindingModel_()
                    .id(movie.id)
                    .movie(movie)
                    .clickListener{ _ ->
                        onItemClick(movie)
                    }
            }

            upcomingCarouselItemModels?.let {
                carousel {
                    id(id--)
                    padding(Carousel.Padding(16.px, 16.px))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(upcomingCarouselItemModels)
                }
            }
        }
    }
}