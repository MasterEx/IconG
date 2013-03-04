package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import mmb.foss.aueb.icong.dialogs.ImageAdapter;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageFileBox extends Box {
	private boolean hasInput = false ;
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
	public void showDialog(final Context context) {
		Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.image_file_dialog_choose);
		dialog.setTitle("Get/Set?");
		dialog.setCancelable(true);
		
		
		Button buttonGet = (Button) dialog.findViewById(R.id.image_file_dialog_choose_btnGet);
		buttonGet.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//TODO create new dialog
				openGallery(context);
			}

		});
		Button buttonSet = (Button) dialog.findViewById(R.id.image_file_dialog_choose_btnSet);
		buttonSet.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				setInput(false);
			}
		});
		dialog.show();

	}
	private void openGallery(Context context)
	{
		Dialog newDialog = new Dialog(context);
		newDialog.setContentView(R.layout.image_file_dialog_get);
		newDialog.setTitle("Choose");
		newDialog.setCancelable(true);
		Gallery g = (Gallery) newDialog.findViewById(R.id.gallery1);
		g.setAdapter(new ImageAdapter(context));
		g.setFadingEdgeLength(40);
		newDialog.show();
		
	}

	public boolean hasInput()
	{
		return hasInput;
	}

	public void setInput(boolean hasInput)
	{
		this.hasInput = hasInput;
	}
}
	