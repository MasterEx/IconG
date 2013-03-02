package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ValueEntryBox extends Box {

	public ValueEntryBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.value_entry);
		buttonX = new int[1][2];
		buttonY = new int[1][2];
		buttonPressed = new boolean[1];
		buttonX[0][0] = 107;
		buttonX[0][1] = 127;
		buttonY[0][0] = 10;
		buttonY[0][1] = 30;
		this.setNoOfInputs(0);
		this.setNoOfOutpus(1);
		this.setHasDialog(true);
		this.setOutput("Value Entry", 0);
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDialog(Context context)
	{
		
		Dialog dialog = new Dialog(context);
		dialog.setCancelable(true);
		dialog.setCanceledOnTouchOutside(true);
		dialog.setTitle(R.id.tv_value_entry);
		dialog.setContentView(R.layout.value_entry_layout);
		final EditText et = (EditText)dialog.findViewById(R.id.et_value_entry);
		TextView tv = (TextView)dialog.findViewById(R.id.tv_value_entry);
		Button btn = (Button)dialog.findViewById(R.id.btn_value_entry_set);
		
		et.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				if(getOutput(0)==null || getOutput(0).equals("Value Entry"))
					et.setText("");
				else
					et.setText(""+getOutput(0));
				
			}
		});
		if(getOutput(0)==null)
			tv.setText("oldvalue : "+" don't have one");
		else
			tv.setText("oldvalue : "+getOutput(0));
		btn.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				float number = Float.parseFloat(et.getText().toString());
				setOutput((int)number, 0);
			}
		});
		
		dialog.show();
		
		
	}

}
