# HiddenFunctionButton-Android

## 概要
5秒以内に10回タップすると反応するViewの拡張クラスです。

隠し機能などにお使いください。

## 使い方
HiddenFunctionButton.javaをダウンロードして、任意のAndroidプロジェクトに組みこんでください。

### サンプルコード
```
<xxx.HiddenFunctionButton
    android:id="@+id/hidden_function_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```
```
hiddenFunctionButton = rootView.findViewById(R.id.hidden_function_button);
hiddenFunctionButton.setOnClickListener(view -> {
    // do something
});
```

### カスタマイズ

検知する秒数とタップの回数は変更することができます。

// 3秒以内に5回タップで反応
```
hiddenButton.setInterval(3);
hiddenButton.setMaxCount(5);
```

## ライセンス

HiddenFunctionButton-Android is released under the MIT license. See [LICENSE](https://github.com/bravesoft-lab/HiddenFunctionButton-Android/blob/master/LICENSE) for details.
