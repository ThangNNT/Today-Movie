package com.example.todaymovie.ui.movie

import androidx.fragment.app.Fragment
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.example.todaymovie.HomeTitleBindingModel_
import com.example.todaymovie.MovieBindingModel_
import com.example.todaymovie.domain.model.Movie
import com.example.todaymovie.domain.model.MovieHome

class MovieController(private val onSeeMoreClick: ()-> Unit, private val onItemClick: (movie: Movie) -> Unit): TypedEpoxyController<MovieHome>() {
    override fun buildModels(data: MovieHome?) {
        data?.let { data1->
            var id = -1

            HomeTitleBindingModel_()
                .id(id--)
                .title("Popular")
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
                    padding(Carousel.Padding(30, 30))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(popularCarouselItemModels)
                }
            }


            HomeTitleBindingModel_()
                .id(id--)
                .title("Now Playing")
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
                    padding(Carousel.Padding(30, 30))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(nowPlayingCarouselItemModels)
                }
            }

            HomeTitleBindingModel_()
                .id(id--)
                .title("Top Rated")
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
                    padding(Carousel.Padding(30, 30))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(topRatedCarouselItemModels)
                }
            }

            HomeTitleBindingModel_()
                .id(id--)
                .title("Upcoming")
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
                    padding(Carousel.Padding(30, 30))
                    Carousel.setDefaultGlobalSnapHelperFactory(null)
                    models(upcomingCarouselItemModels)
                }
            }
        }
    }
}