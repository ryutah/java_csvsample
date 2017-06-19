# 6/14(水) ソースレビュー会 リファクタリング by ryutah

## 実行
```console
$ cd $PROJECT_ROOT
$ gradlew run
```

## テスト実行
```console
$ cd $PROJECT_ROOT
$ gradlew test
```

\#IDEへのインポート方法とか
* [IntelliJ IDEA](https://www.jetbrains.com/help/idea/2017.1/importing-a-gradle-project-or-a-gradle-module.html)
* [Eclipse](http://www.vogella.com/tutorials/EclipseGradle/article.html##import-an-existing-gradle-project)

## 課題とか
* ダブルクォーテーション囲いのCSV未対応
* カラム内改行とか未対応
* CSV最終行に改行が入るか入らないか考えてない
* CSVWriterクラスとか作って、CSV出力対応する
* 標準APIどこまで使っちゃダメなのかよくわかってない
* あまりAPIの使用感を検証できてない

誰かやって
