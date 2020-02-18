package com.ascena.bestfitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FitResultActivity extends AppCompatActivity {

    private TextView sizeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_result);

        sizeTextView = (TextView) findViewById(R.id.size);
        sizeTextView.setText(calculateSize(0,0,0,'\0','\0'));
    }

    private String calculateSize(int waist, int height, double lowHip, char fit, char thigh){
        //System.out.println("Hello world");
        //int waist=0, height=0,
        int i=0;
        int SizeW=0, SizeLH=0, MidSizeW=0, MidSizeLH=0,FinalSize=0, LowerSize=0 , UpperSize=0;
        //double lowHip=0;
        //char fit, thigh;
        //Take user input
        waist=33;
        lowHip=42;
        height=176;
        fit='\0';
        thigh='S';

        if ((waist % 2)==0 || (waist+0.5)%2==0){
            for (i=0; i<=11; i++)
                if (waist== SizeConstants.W[i])
                    SizeW = SizeConstants.S[i];
        }else{
            for (i=0; i<=10; i++)
                if (waist==SizeConstants.MID_LIMIT_W[i] || (waist+0.5)==SizeConstants.MID_LIMIT_W[i])
                    MidSizeW= SizeConstants.MID_LIMIT_S[i];
        }
        for (i=0 ; i<=11; i++)
            if (lowHip==SizeConstants.LH[i] || (lowHip+0.5)==SizeConstants.LH[i])
                SizeLH= SizeConstants.S[i];

        if (SizeLH==0)
            for (i=0 ; i<=10; i++)
                if (lowHip==SizeConstants.MID_LIMIT_LH[i] || (lowHip+0.5)==SizeConstants.MID_LIMIT_LH[i])
                    MidSizeLH=SizeConstants.MID_LIMIT_S[i];

        //Step 6:
        if (SizeW !=0 && SizeLH!=0)
            if (SizeW==SizeLH)
                FinalSize=SizeW;
            else
            if (SizeW>SizeLH) {
                UpperSize = SizeW;
                LowerSize = SizeLH;
            }else {
                UpperSize = SizeLH;
                LowerSize = SizeW;
            }
        else
        if(MidSizeW!=0 && MidSizeLH!=0)
            if (MidSizeW==MidSizeLH) {
                UpperSize = MidSizeW + 1;
                LowerSize = MidSizeW - 1;
            }else
                FinalSize=(MidSizeW+MidSizeLH)/2;

        if(MidSizeW!=0 && SizeLH!=0)
            if (MidSizeW>SizeLH){
                UpperSize=MidSizeW+1;
                LowerSize=SizeLH;
            }else{
                UpperSize=SizeLH;
                LowerSize=MidSizeW-1;
            }
        else
        if (SizeW!=0 && MidSizeLH!=0)
            if (SizeW>MidSizeLH) {
                UpperSize=SizeW;
                LowerSize=MidSizeLH-1;
            }else{
                UpperSize=MidSizeLH+1;
                LowerSize=SizeW;
            }

        //Step 8: Fit Calculation
        if (height <=160.02)
            if (thigh != '\0')
                if (thigh == 'S')
                    fit = 'P'; //Petite
                else
                    fit='S';//Short
            else
                fit = 'P'; //Petite
        else if ((height >=160.03) && (height <162.56))
            fit='S';//Short
        else if (height== 162.56)
            if (thigh != '\0')
                if (thigh == 'S')
                    fit='S';//Short
                else
                    fit='R';//Regular
            else
                fit='S';//Short
        else if ( (height >162.56) && (height <172.72))
            fit='R';//Regular
        else if ( height==172.72)
            if (thigh != '\0')
                if (thigh == 'S')
                    fit='R';//Regular
                else
                    fit='L';//Long
            else
                fit='R';//Regular
        else if ( height >172.72)
            fit='L';//Long


        // Step 9:
        if (FinalSize!=0 ){

            return String.valueOf((FinalSize+fit));
            /*System.out.println(FinalSize);
            System.out.print(fit);*/
        }

        else{

            return String.valueOf((UpperSize+fit) + " - " + (LowerSize+fit));
            /*System.out.println("Your upper size is:");
            System.out.print(UpperSize);
            System.out.print(fit);
            System.out.println();
            System.out.println("Your lower size is:");
            System.out.print(LowerSize);
            System.out.print(fit);
            System.out.println();*/
        }
    }
}
