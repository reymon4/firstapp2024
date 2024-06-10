package com.reymon.myFirstApp.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.reymon.myFirstApp.data.network.entities.tmdb.rated.Result
import com.reymon.myFirstApp.databinding.ActivityDashboardBinding
import com.reymon.myFirstApp.logic.tmdb.GetAllTopRatedUsercase
import com.reymon.myFirstApp.ui.adapters.TopRatedDiffUtilAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private var items: MutableList<Result> = mutableListOf()
    private lateinit var topRatedDiffUtilAdapter: TopRatedDiffUtilAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        // Enable Activity Transitions. Optionally enable Activity transitions in your
        // theme with <item name=”android:windowActivityTransitions”>true</item>.
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        // Set the transition name, which matches Activity A’s start view transition name, on
        // the root view.
        findViewById<View>(android.R.id.content).transitionName = "shared_log_dashboard"

        // Attach a callback used to receive the shared elements from Activity A to be
        // used by the container transform transition.
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        // Set this Activity’s enter and return transition to a MaterialContainerTransform
        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 300L
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 250L
        }
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initListeners()
    }
    private fun initListeners() {
        binding.swipeRefresh.setOnRefreshListener {
            initData()
            binding.swipeRefresh.isRefreshing = false
        }
    }
    private fun initRecyclerView() {
        topRatedDiffUtilAdapter = TopRatedDiffUtilAdapter()
        binding.rvTopRated.adapter = topRatedDiffUtilAdapter
        binding.rvTopRated.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        initData()

    }

    fun initData() {
        lifecycleScope.launch(Dispatchers.IO) {
            // Código que no afecta la UI
            val resultItems = GetAllTopRatedUsercase().invoke()
            Log.d("DashboardActivity", resultItems.toString())

            withContext(Dispatchers.Main) {
                // Todo lo que modifica la UI debe ir aquí
                binding.progressBarTopRated.visibility = View.VISIBLE

                resultItems.onSuccess {
                    items = it!!.toMutableList()
                    topRatedDiffUtilAdapter.submitList(items.toList())
                    binding.progressBarTopRated.visibility = View.INVISIBLE
                }
                resultItems.onFailure {
                    Snackbar.make(
                        binding.rvTopRated,
                        "Error al cargar los datos",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    binding.progressBarTopRated.visibility = View.INVISIBLE
                }
            }
        }
    }



}
