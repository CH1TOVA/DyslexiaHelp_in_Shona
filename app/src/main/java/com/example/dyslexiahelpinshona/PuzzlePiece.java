package com.example.dyslexiahelpinshona;

import android.content.Context;

import androidx.annotation.NonNull;

public class PuzzlePiece extends androidx.appcompat.widget.AppCompatImageView{
    public int xCoord;
    public int yCoord;
    public int pieceWidth;
    public int pieceHeight;
    public boolean canMove = true;

    public PuzzlePiece(@NonNull Context context) {
        super(context);
    }
}
