package com.example.textrecognitionapp;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognizer;

public class TextAnalyzer {
    private TextRecognizer recognizer;

    public TextAnalyzer(TextRecognizer recognizer) {
        this.recognizer = recognizer;
    }

    // When using Latin script library
//        TextRecognizer recognizer =
//                TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

    // When using Chinese script library
//        TextRecognizer recognizer =
//                TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
//
//// When using Devanagari script library
//        TextRecognizer recognizer =
//                TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());
//
//// When using Japanese script library
//        TextRecognizer recognizer =
//                TextRecognition.getClient(new JapaneseTextRecognizerOptions.Builder().build());
//
//// When using Korean script library
//        TextRecognizer recognizer =
//                TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
    public void analyze(Bitmap bitmap, AnalyzeCallBack callBack) {
        InputImage image = InputImage.fromBitmap(bitmap, 0);

        recognizer.process(image)
                .addOnSuccessListener(visionText -> {
                    String resultText = visionText.getText();
                    callBack.onAnalyzeSuccess(resultText);
                })
                .addOnFailureListener(
                        e -> Log.d("MainActivity", "Analyze failed"));
    }
}
