# KMM DI Sample
Sample demo app with integrated [Multiplatform-DI](https://github.com/anioutkazharkova/di-multiplatform-lib)

Mobile client for [Movies DB open API](https://www.themoviedb.org) with common BL and architecture.

## Features 

- [X] Common architecture (VIP)
- [X] Common network (Ktor)
- [X] Common dependency injection
- [X] Coroutines for concurrency

## Next
- [ ] Support of Kotlin 1.5.0
- [ ] Suport Coroutine Flows 
- [ ] Support ViewBinding in Android
- [ ] Support of Jetpack Compose and SwiftUI

## Architecture and common concurrency

App supports VIP architecture (sort of Clean architecture):
- Interactor to communicate with common BL (IInteractor + BaseInteractor<IView>)
- Presenter to process data from interactor and send to bound view (IPresenter + BasePresenter<IView>)
- View (hold a link to interactor) (IView)

Also every VIP-module contains specific configurator to create all components and connect them together.

E.g: 
```
class MoviesListConfigurator : IConfigurator {
    companion object {
        val instance = MoviesListConfigurator()
    }

    override fun create(view: IView): IInteractor? {
        val interactor: IMoviesListInteractor = MoviesListInteractor()
        val presenter = MoviesListPresenter()
        interactor.presenter = presenter
        presenter.view = view as? IMoviesListView
        return interactor
    }
}
```

Every  interactor implements interface:

```
interface IInteractor {
    fun setup(di: DIManager)

    fun attachView()

    fun detachView()
}
```

Also it derives BaseInteractor<IView> with incapsulated common concurrency:
```
abstract class BaseInteractor<T : IView>(private val coroutineContext: CoroutineContext) {
    protected lateinit var scope: ModuleCoroutineScope

    fun attachView() {
        scope = ModuleCoroutineScope(coroutineContext)
    }

    fun detachView() {
        scope.viewDetached()
    }
}

class ModuleCoroutineScope(
    context: CoroutineContext
) : CoroutineScope {

    private var onViewDetachJob = Job()
    override val coroutineContext: CoroutineContext = context + onViewDetachJob

    fun viewDetached() {
        onViewDetachJob.cancel()
    }
}
```
  
All dependencies should be resolved in setup method of interactor: 

```
class MoviesListInteractor :
    BaseInteractor<IMoviesListView>(uiDispatcher),
    IMoviesListInteractor {
    private var moviesService: MoviesService? = null
    override var presenter: IMoviesListPresenter? = null

    private var moviesList: ArrayList<MoviesItem> = arrayListOf()

    override fun setup(di: DIManager) {
        this.moviesService = di.resolve<MoviesService>(MoviesService::class) as? MoviesService
    }
```


The connection between view and interactor should be setup on native side:

```
// iOS MoviesListVC.swift

 @InjectedInView  var interactor: IMoviesListInteractor?

 override func viewDidLoad() {
        super.viewDidLoad()
        
        $interactor.view = self
   }
```

```
//Android MoviesListFragment.kt
val interactor: IMoviesListInteractor? by interactors(this)

//or 

var interactor: IMoviesListInteractor? = null

 override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_list_fragment, container, false)?.also {
            this.interactor = App.container.resolve(this) as IMoviesListInteractor?
        }
    }
```

More info about property wrappers and delegates with DI you can find in WIKI (soon)
