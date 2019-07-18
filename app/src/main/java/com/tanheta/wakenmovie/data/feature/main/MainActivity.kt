package com.tanheta.wakenmovie.data.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.tanheta.wakenmovie.R
import com.tanheta.wakenmovie.base.extensions.isVisible
import com.tanheta.wakenmovie.base.extensions.showToast
import com.tanheta.wakenmovie.data.model.dto.MovieDto
import com.tanheta.wakenmovie.data.model.dto.SimpleMovieDto
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.View {
    override val presenter by inject<MainContract.Presenter> {parametersOf(this)}

    private val adapter by lazy { MovieAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        presenter.loadMovies(1)
    }

    override fun onResume() {
        super.onResume()

        presenter.loadMovies(1)
    }

    override fun showLoadingMovies() {
        mainViewLoading.isVisible = true
    }

    override fun hideLoadingMovies() {
        mainViewLoading.isVisible = false
    }

    override fun onSuccessfulLoadMovies(movies: List<SimpleMovieDto>) {
        adapter.data = movies
    }

    override fun onFailureLoadMovies(message: String) {
        showToast(message)
    }

    private fun setupViews() {
        setSupportActionBar(mainToolbar as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mainToolbar.tcTxtTitle.setText(R.string.app_title)

        mainRecMovies.layoutManager = GridLayoutManager(this, 2)
        mainRecMovies.adapter = adapter
    }


}