package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageFileBox extends Box {

	public ImageFileBox(Context context) {
		super(context, R.drawable.image_file);
		buttonX = new int[2][2];
		buttonY = new int[2][2];
		buttonPressed = new boolean[2];
		buttonX[0][0] = 6;
		buttonX[0][1] = 26;
		buttonX[1][0] = 106;
		buttonX[1][1] = 126;
		buttonY[0][0] = 10;
		buttonY[0][1] = 30;
		buttonY[1][0] = 10;
		buttonY[1][1] = 30;
		this.setNoOfInputs(1);
		this.setNoOfOutpus(1);
		this.setHasDialog(true);
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDialog(final Context context)
	{
		 Dialog dialog = new Dialog(context);
         dialog.setContentView(R.layout.dialog);
         dialog.setTitle("Yaw dialog test");
         dialog.setCancelable(true);
         //there are a lot of settings, for dialog, check them all out!
         //set up text
         TextView text = (TextView) dialog.findViewById(R.id.TextView01);
         text.setText("yaw yaw yaw yaw \n yaw yaw yaw yaw yaw" +
         		"\nyaw yaw yaw yaw yaw yaw yaw yaw" +
         		"\nyaw yaw yaw yaw yaw yaw yaw yaw" +
         		"\nyaw yaw yaw yaw yaw yaw yaw yaw" +
         		"\nyaw yaw yaw yaw yaw yaw yaw yaw" +
         		"\nyaw yaw yaw yaw yaw yaw yaw yaw" +
         		"\nyaw yaw yaw yaw yaw yaw yaw yaw" );

         //set up image view
         ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
         img.setImageResource(R.drawable.image_file);
         Button button = (Button) dialog.findViewById(R.id.Button01);
         button.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View arg0)
			{
				Toast.makeText(context, "Yawwwwwwwwwlo", Toast.LENGTH_LONG);
				
			}
		});
         dialog.show();
		
	}

}
