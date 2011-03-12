package org.cirrus.mobi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class GradientDemo extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public static class GradientView extends View 
    {

		private static final float GRADIENT_LENGTH = 100;
		private Paint gradientBoxPaint;
		private Paint gradientBoxPaintFail;

		public GradientView(Context context) {
			super(context);
			
			gradientBoxPaint = new Paint();
			gradientBoxPaint.setAntiAlias(true);
			gradientBoxPaint.setDither(true);
			gradientBoxPaint.setShader(new LinearGradient(0, 0, 0, GRADIENT_LENGTH, new int[]{Color.RED, Color.YELLOW, Color.GREEN},
					new float[]{0f,0.5f,1f}, Shader.TileMode.CLAMP));
			gradientBoxPaint.setStrokeWidth(1f);	

			gradientBoxPaintFail = new Paint();
			gradientBoxPaintFail.setAntiAlias(true);
			gradientBoxPaintFail.setDither(true);
			gradientBoxPaintFail.setShader(new LinearGradient(0, 0, 0, GRADIENT_LENGTH, new int[]{Color.RED, Color.YELLOW, Color.GREEN},
					null, Shader.TileMode.CLAMP));
			gradientBoxPaintFail.setStrokeWidth(1f);	

		}
		
		public GradientView(Context context, AttributeSet attr)
		{
			this(context);
		}
    	
		@Override
		protected void onDraw(Canvas canvas) {
			
			canvas.drawRect(0,0,50,200, gradientBoxPaint);
			
			canvas.drawRect(100,0,150,200, gradientBoxPaintFail);
		}
    }
}