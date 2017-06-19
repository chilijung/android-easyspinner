# EasySpinner

Styling and manipulating data in android spinner is hard. Make it easy.

## Demo

<img src="./preview/demo.png" width="250"/>

## Demo Spinner types

- [Horizontal Spinner](#horizontalspinner)
- [Vertical Spinner](#verticalspinner)
- [Normal Spinner](#normalspinner)

#### Horizonal spinner

<img src="./preview/horizonal.png" width="250"/>

```xml
<io.canner.easyspinner.HorizontalSpinner
    android:id="@+id/spinner1"
    style="@style/spinnerForm"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:entries="@array/spn_list"
    app:itemLayout="@layout/test_item"
    app:itemSelectedLayout="@layout/test_item_selected"
    app:nothingSelectedLayout="@layout/test_nothing_select"
    app:prompt="Select a car type... "
    app:spinnerMode="dialog"
    app:title="Horizontal spinner" />
```

#### Vertical spinner

<img src="./preview/vertical.png" width="250"/>

```xml
<io.canner.easyspinner.VerticalSpinner
    android:id="@+id/verticalSpinner"
    style="@style/spinnerForm"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:entries="@array/spn_list"
    app:itemLayout="@layout/test_item"
    app:itemSelectedLayout="@layout/test_item_selected"
    app:nothingSelectedLayout="@layout/test_nothing_select"
    app:prompt="Select a car type... "
    app:spinnerMode="dialog"
    app:title="Vertical spinner" />
```

#### Normal spinner

<img src="./preview/normal.png" width="250"/>

```xml
<io.canner.easyspinner.SimpleSpinner
    android:id="@+id/simpleSpinner"
    style="@style/spinnerForm"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:entries="@array/spn_list"
    app:prompt="Select a car type... "
    app:spinnerMode="dropdown" />
```

## Setting spinner styles - style attributes

You can setup your spinner customized styles with following settings in layout attributes.

####  style

style attribute can setup your spinner style

#### app:itemLayout

passing your layout resourceId to setup your own itemLayout.

#### app:itemSelectedLayout

when the item selected it will be shown using `app:itemSelectedLayout`

#### app:nothingSelectedLayout

when nothing is selected, it will display this layout `app:nothingSelectedLayout` you could replace with your own placeholder here.

## Other Attributes

#### app:entries

setup your spinner entries.

#### app:prompt

setup your spinner prompt message.

#### app:spinnerMode

spinnerMode could be either `dropdown` or `dialog`.

#### title

setup title.

## Setup Spinner methods

#### spinner.setOnItemSelectedListener

```java
this.spinnerTest = (HorizontalSpinner) findViewById(R.id.spinner1);
spinnerTest.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        // your code here
        Log.v("SpinnerTest1 position", String.valueOf(position));
        Log.v("SpinnerTest1 id", String.valueOf(id));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
        // your code here
        Log.v("SpinnerTest1", "nothing selected");
    }
}));
```

## clear entries

#### spinner.clear();

## add new entry

#### spinner.add(String)

```java
spinnerTest.add("test data");
```

## add new entries

#### spinner.addCollection(Collection)

```java
ArrayList<String> testData = new ArrayList();
testData.add("test 1");
testData.add("test 2");
testData.add("test 3");
testData.add("test 4");

spinnerTest.addAll(testData);
```

## License

MIT
