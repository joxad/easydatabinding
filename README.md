
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-easydatabinding-green.svg?style=true)](https://android-arsenal.com/details/1/4106)

# easydatabinding
This project goal is to create activity fragment and views, with less code to be more efficient on the view models


# Version : 1.1.0
# Goal

I used DataBinding for a few weeks since Google allows us to use it.

For now i saw a lot of duplicated code to instantiate an activity or a fragment.
So I make this library to avoid boilerplate, and you will be able to focus on your code .


## Thanks

Very useful lib used in easydatabinding :

https://github.com/evant/binding-collection-adapter/

If you want to use it without easydatabinding , just add this
compile "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:2.0.1"
compile "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:2.0.1"

It handles the databinding inside the recyclerview => No adapter to write :)



## Side project very usefull if you are lazy (I am)


https://github.com/joxad/generator-android-template

If you know yeoman, you won't be surprised.
It is a generator that will help you create the activity/vm data (see below and the sample for more details)


## How to use it

It requires at least android gradle plugin 2.3.0.

Gradle root :

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/joxad/maven"
    }
}

```

Gradle project :

```groovy

compile "com.joxad.easydatabinding:lib:$currentVersion"

```

### Fast Sample

With the library an activity will be :


```java
public class ActivityMain extends ActivityBase<ActivityMainBinding,ActivityMainVM> {

    @Override
    public int data() {
        return BR.activityMainVM;
    }

    @Override
    public int layoutResources() {
        return R.layout.activity_main;
    }

    @Override
    public ActivityMainBaseVM baseActivityVM(ActivityMainBinding binding) {
        return new ActivityMainVM(this, binding);
    }

}
```

And your VM :

```java
public class ActivityMainVM extends ActivityBaseVM<ActivityMain, ActivityMainBinding> {

    /***
     * This is the itemView view that will put the user in the
     */
    public ItemBinding<PeopleVM> itemView = ItemBinding.of(peopleVM, item_people);

    public ObservableArrayList<PeopleVM> items;

    /***
     * @param activity
     * @param binding
     */
    public ActivityMainVM(ActivityMain activity, ActivityMainBinding binding) {
        super(activity, binding);
    }

    @Override
    public void onCreate() {

        StarWarsApi.INSTANCE.init(activity);
        items = new ObservableArrayList<>();



    }

    @Override
    public void onResume() {
        super.onResume();
        items.clear();
        StarWarsApi.INSTANCE.people().enqueue(new Callback<PeopleResult>() {
            @Override
            public void onResponse(Call<PeopleResult> call, Response<PeopleResult> response) {
                for (Result people : response.body().getResults()) {
                    items.add(new PeopleVM(activity, people).setOnSelected(new PeopleVM.OnSelected() {
                        @Override
                        public void people(Result people) {
                            goToActivityPeople(people);
                        }
                    }));
                }
            }

            @Override
            public void onFailure(Call<PeopleResult> call, Throwable t) {
                Log.d(ActivityMain.class.getSimpleName(), t.getLocalizedMessage());
            }
        });
    }

    private void goToActivityPeople(Result people) {
        activity.startActivity(new Intent(activity, ActivityPeople.class).putExtra(Extra.PEOPLE, people));
    }
}

```

You will need a layout :

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <import type="me.tatarka.bindingcollectionadapter2.LayoutManagers" />

        <variable
            name="activityMainVM"
            type="joxad.easydatabinding.sample.home.ActivityMainVM" />
    </data>

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".home.ActivityMainVM">

        <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:itemView="@{activityMainVM.itemView}"
            app:items="@{activityMainVM.items}"
            app:layoutManager="@{LayoutManagers.linear()}" />
    </RelativeLayout>
</layout>
```

### WTF : you have two classes ??? Why don't you put all the logic in the ActivityBase / FragmentBase ?

Well, in order to use the databinding, the classes that will handle the view must extends BaseObservable, and in some cases,
some data needs to be visible only in this unique fragment.

So the activity now become a way to access the views (with the bindings) and the VM class will handle all the treatments.



### More


- See the package sample in order to see in working with a API using retrofit. I used https://swapi.co/ for sample.


- To handle Result there are useful interfaces you can put in your VM's class of your activity

For example, you can implement :
```java
IPermission //handle permission result from android 5.0+ 
IResult // handle the result from another activity
INewIntent // called when activity receives a new intent

```

- Handler

All the ActivityBaseVM/FragmentBaseVM have 2 handler :
- uiHandler to handle runnable to do tasks on the uiThread (like showToast on a callback from a WS)
- handler classic to create runnable on the fly 

## Notes about the DataBinding

- Each Activity or Fragment is linked to a viewmodel who will expose the data to the view (layout) and handle some specific fucntionnalities


- ViewModel will also handle some treatments :

    - WS Calls . Database to update the recyclerview of the layout
    - activityresult of activity (for facebook . google login for example)

