package com.example.textrecognitionapp;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognizer;

public class TextAnalyzer {
    private TextRecognizer recognizer;

    public TextAnalyzer(TextRecognizer recognizer) {
        this.recognizer = recognizer;

        // When using Latin script library
//        recognizer =
//                TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        // When using Chinese script library
//         recognizer =
//                TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
//
//// When using Devanagari script library
//         recognizer =
//                TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());
//
//// When using Japanese script library
//         recognizer =
//                TextRecognition.getClient(new JapaneseTextRecognizerOptions.Builder().build());
//
//// When using Korean script library
//         recognizer =
//                TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
    }

    /**
     * Analyzes the provided bitmap image using a text recognizer and invokes the callback
     * with the analysis result.
     *
     * @param bitmap   The bitmap image to be analyzed.
     * @param callBack The callback to be invoked with the analysis result.
     */
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
