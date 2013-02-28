package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;

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
	}

	@Override
	public void function()
	{
		// TODO Auto-generated method stub
		
	}

}
