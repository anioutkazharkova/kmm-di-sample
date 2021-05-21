package com.example.movies.ui.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.kmmdi.androidApp.App
import com.azharkova.kmmdi.androidApp.R
import com.azharkova.kmmdi.androidApp.ui.interactors
import com.azharkova.kmmdi.shared.data.MoviesItem
import com.azharkova.kmmdi.shared.movieslist.IMoviesListInteractor
import com.azharkova.kmmdi.shared.movieslist.IMoviesListView
import com.example.movies.ui.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment(), com.azharkova.kmmdi.shared.movieslist.IMoviesListView {

    companion object {
        fun newInstance() = MoviesListFragment()
    }

    private var adapter: MoviesAdapter? = null
    private var list: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_list_fragment, container, false)?.also {
            list = it?.findViewById<RecyclerView>(R.id.list)
            list?.layoutManager = LinearLayoutManager(this.activity)
            this.interactor = App.container.resolve(this) as com.azharkova.kmmdi.shared.movieslist.IMoviesListInteractor?
            adapter = MoviesAdapter(this::onMovieClick)
        }
    }

    private fun onMovieClick(index: Int) {
        TODO("Not yet implemented")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        // this.interactor?.attachView()
        // this.interactor?.loadMovies()

        inter?.attachView()
        inter?.loadMovies()
    }

    override fun onPause() {
        this.interactor?.detachView()
        super.onPause()
    }

    val inter: com.azharkova.kmmdi.shared.movieslist.IMoviesListInteractor? by interactors(this)

    override var interactor: com.azharkova.kmmdi.shared.movieslist.IMoviesListInteractor? = null

    override fun setup(items: List<com.azharkova.kmmdi.shared.data.MoviesItem>) {
        adapter?.updateItems(items)
        list?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }
}
