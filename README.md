# datetimepicker

Date Time Picker For Androidx

## Get Started
Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }	
	}
}
```
Add the dependency

```
dependencies {
	implementation 'com.github.dutchmanbd:datetimepicker:1.0.0'
}
```

## How to use

### Date Picker Dialog (In Activity)

```
    tvDate.setOnClickListener {
        val datePickerFragment = DatePickerFragment()
        datePickerFragment.show(supportFragmentManager, "AnyTextHere"){
            Log.d(TAG, "onCreate: Date: $it")
            tvDate.text = it
        }
    }
```

### Time Picker Dialog (In Activity)

```
    tvTime.setOnClickListener {
        val timePickerFragment = TimePickerFragment()
        timePickerFragment.show(supportFragmentManager, "AnyTextHere"){
            Log.d(TAG, "onCreate: Time: $it")
            tvTime.text = it
        }
    }
```


### Date Picker Dialog (In Fragment)

```
    tvDate.setOnClickListener {
        val datePickerFragment = DatePickerFragment()
        datePickerFragment.show(parentFragmentManager, this.tag){
            Log.d(TAG, "onActivityCreated: Date: $it")
            tvDate.text = it
        }
    }
```

### Time Picker Dialog (In Fragment)

```
    tvTime.setOnClickListener {
        val timePickerFragment = TimePickerFragment()
        timePickerFragment.show(parentFragmentManager, this.tag){
            Log.d(TAG, "onActivityCreated: Date: $it")
            tvTime.text = it
        }
    }
```
