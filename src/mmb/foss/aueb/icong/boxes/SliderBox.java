package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SliderBox extends Box {

	public SliderBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.slidercorrect);
		buttonX = new int[1][2];
		buttonY = new int[1][2];
		buttonPressed = new boolean[1];
		buttonX[0][0] = 107;
		buttonX[0][1] = 127;
		buttonY[0][0] = 10;
		buttonY[0][1] = 30;
		this.setNoOfInputs(0);
		this.setNoOfOutpus(1);
		this.setOutput(6, 0);
		this.setHasDialog(true);
		this.setOutput((int)125, 0);
		
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub

	}
	public void drawThingy(Canvas canvas,Bitmap btmp)
	{
		int number = (Integer) getOutput(0);
		int startX = (int) (getX()+11*Box.getZoom()) ;
		int startY = (int) (getY()+20*Box.getZoom());
		Log.e("Yolo,inside thingy",""+Box.getZoom());
		float width = (float) (87*Box.getZoom());
		float starting_position_x =(width/256)*number +startX-3 ;
		float starting_position_y = startY -btmp.getHeight()/2 ;
		canvas.drawBitmap(btmp, starting_position_x, 
				starting_position_y, new Paint());
		
	}
	@Override
	public void showDialog(Context context)
	{
		Dialog dialog= new Dialog(context);
		dialog.setContentView(R.layout.slider_layout);
		dialog.setTitle("Slider");
		dialog.setCancelable(true);
		dialog.setCanceledOnTouchOutside(true);
		TextView tvold = (TextView) dialog.findViewById(R.id.slider_textView1);
		final TextView tvnew = (TextView) dialog.findViewById(R.id.slider_textView2);
		final SeekBar sb = (SeekBar)dialog.findViewById(R.id.slider_seekBar1);
		Button btn = (Button)dialog.findViewById(R.id.slider_button1);
		tvold.setText("Old value : "+getOutput(0));
		
		sb.setMax(255);
		sb.setProgress((Integer) getOutput(0));
		OnSeekBarChangeListener sbCustomListener = new OnSeekBarChangeListener() {
			@Override
		    public void onStopTrackingTouch(SeekBar seekBar)
			{
		            
		    }

		    @Override
		    public void onStartTrackingTouch(SeekBar sb)
		    {
		            
		    }
		    @Override
		    public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) 
		    {
		    	//sb.setProgress(progress);
		    	tvnew.setText("New value : "+sb.getProgress());
		           
		    }
		};
		sb.setOnSeekBarChangeListener(sbCustomListener);
		btn.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				setOutput(sb.getProgress(), 0);
				
			}
		});
		dialog.show();
	}	

}
