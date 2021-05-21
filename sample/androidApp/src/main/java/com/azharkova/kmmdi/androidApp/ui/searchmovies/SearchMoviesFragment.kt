package com.example.movies.ui.searchmovies

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.kmmdi.androidApp.R
import com.example.movies.ui.adapter.MoviesAdapter
import com.zigis.materialtextfield.MaterialTextField
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchMoviesFragment @Inject constructor() : Fragment() {

    companion object {
        fun newInstance() = SearchMoviesFragment()
    }
    private var adapter: MoviesAdapter? = null
    private var list: RecyclerView? = null
    private var inputView: MaterialTextField? = null
    // private  val viewModel = SearchViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_movies_fragment, container, false)?.also {
            setHasOptionsMenu(true)
            inputView = it.findViewById<MaterialTextField>(R.id.text_input)
            list = it?.findViewById<RecyclerView>(R.id.list)
            list?.layoutManager = LinearLayoutManager(this.activity)
            adapter = MoviesAdapter(this::onMovieClick)
        }
    }

    private fun setupObservers() {
        this.inputView?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val query = s.toString()
            }
        })
    }

    fun onMovieClick(index: Int) {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.setupObservers()
    }

    override fun onResume() {
        super.onResume()
    }
}
