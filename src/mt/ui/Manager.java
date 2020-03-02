package mt.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import mt.ui.form.SplashForm;
import mt.ui.form.LoginForm;
import mt.ui.form.MainForm;
import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.KeyStroke;
import mt.listener.OnLoginListener;
import mt.model.LoginInfo;
import mt.service.WebService;
import mt.ui.form.DashForm;
import mt.util.Def;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 *
 * @author John
 */
public class Manager {
    public static LoginForm mLoginForm;
    public static MainForm mMainForm;
    public static SplashForm mSplashForm;
    public static DashForm mDashForm;
    
    private static Manager mManager;
    Provider mProvider;
    LoginInfo mLoginInfo = new LoginInfo();
    String mCurrentScreenShot = "";    
    
    public static Manager getInstance() {
        if (mManager == null) {
            mManager = new Manager();            
        }
        
        return mManager;
    }

    public void init() {
        if (mLoginForm == null) {
            mLoginForm = new LoginForm();
            mLoginForm.setVisible(false);
        }

        if (mMainForm == null) {
            mMainForm = new MainForm();
            mMainForm.setVisible(false);
        }

        if (mDashForm == null){
            //mDashForm = new DashForm();
            //mDashForm.setVisible(false);
        }

    }
    
    public void showForm(int formId, boolean isVisible) {
        switch (formId) {
            case Def.DEF_FORM_SPLASH:
                if (mSplashForm == null) {
                    mSplashForm = new SplashForm();
                }

                mSplashForm.setVisible(isVisible);
                mSplashForm.setAutoRequestFocus(isVisible);
                
                break;
                
            case Def.DEF_FORM_LOGIN:
                if (mLoginForm == null) {
                    mLoginForm = new LoginForm();
                }

                mLoginForm.setVisible(isVisible);
                mLoginForm.setAutoRequestFocus(isVisible);
        
                break;
                
            case Def.DEF_FORM_MAIN:
                if (mMainForm == null) {
                    mMainForm = new MainForm();
                }

                mMainForm.setVisible(isVisible);
                mMainForm.setAutoRequestFocus(isVisible);
                break;
                
            case Def.DEF_FORM_DASH:
                if (mDashForm == null) {
                    mDashForm = new DashForm();
                }
                
                mDashForm.setVisible(isVisible);
                mDashForm.setAutoRequestFocus(isVisible);
                break;
        }
    }
    
    public void closeProgram() {
        System.exit(0);
    }
    
    public void keyEventCatchStart() {
        mProvider = Provider.getCurrentProvider(false);
        
        mProvider.register(KeyStroke.getKeyStroke("control alt F"), new HotKeyListener() {
            
            @Override
            public void onHotKey(HotKey hotkey) {                
                System.out.println("control alt F was pressed.");  
                printLog("control alt F was pressed.");
                screenShot();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    public void keyEventCatchStop() {
        mProvider.reset();
        mProvider.stop();
    }
    public void doLogin(String email, String password) {
        
        Call<ResponseBody> responseBodyCall = WebService.getInstance().postLogin(email, password);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // clear products array                
                try {
                    if (response.code() == 200) {
                        String strJson = response.body().string();
                        JSONObject jObject = new JSONObject(strJson);

                        if (mLoginInfo == null)
                            mLoginInfo = new LoginInfo();

                        mLoginInfo.error = jObject.getString("error");
                        if ("none".equals(mLoginInfo.error)) {
                            mLoginInfo.success = jObject.getBoolean("success");
                            mLoginInfo.token = jObject.getString("token");
                        } else {
                            onLoginFailed(mLoginInfo.error);
                        }

                        if (mLoginInfo.success) {
                            onLoginSucceed(mLoginInfo);
                        } else {
                            onLoginFailed(mLoginInfo.error);
                        }
                    } else {
                        onLoginFailed("invalid credentials");
                    }
                                        
                    
                } catch (Exception e) {
                    onLoginFailed(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onLoginFailed("Error");
            }            
        });        
    }
    
    public void uploadImage(MultipartBody.Part fileBody) {
        printLog("upload Image start");
        String auth = "Bearer " + mLoginInfo.token;
        Call<ResponseBody> responseBodyCall = WebService.getInstance().postUploadImage(fileBody, auth);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // clear products array                
                try {
                    String strJson = response.body().string();
                    JSONObject jObject = new JSONObject(strJson);                  
                             
                    
                    boolean result = jObject.getBoolean("success");
                                        
                    if (result) {
                        showMessageDialog(null, "Uploading succeed");
                    } else {
                        showMessageDialog(null, "Uploading failed");
                    }                    
                    
                } catch (Exception e) {
                    showMessageDialog(null, "Uploading failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                showMessageDialog(null, "network error");
            }            
        });        
    }
    
    private void onLoginSucceed(LoginInfo loginInfo) {        
        
        showForm(Def.DEF_FORM_DASH, true);
        showForm(Def.DEF_FORM_LOGIN, false);
        mLoginForm.dispose();

        keyEventCatchStart();
    }
    
    private void onLoginFailed(String error) {
        showMessageDialog(null, error);
    }
    
    public void screenShot() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
        Calendar now = Calendar.getInstance();
        Robot robot;
        try {            
            robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            String currentPath = MainForm.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodePath = URLDecoder.decode(currentPath, "UTF-8");
            decodePath = decodePath.substring(1,decodePath.lastIndexOf("/") );
            //mCurrentScreenShot = decodePath+"/" + formatter.format(now.getTime()) + ".jpg";
            mCurrentScreenShot = formatter.format(now.getTime()) + ".jpg";
            printLog(mCurrentScreenShot);
            File file = new File(mCurrentScreenShot);
            ImageIO.write(screenShot, "JPG", file);
            printLog(mCurrentScreenShot + " write succeed");
            
            // ready for post
            RequestBody requestFile = RequestBody.create(MediaType.parse("text/plain"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("evidence", file.getName(), requestFile);
            uploadImage(body);
            
        } catch (AWTException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            printLog("Error");
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            printLog("Error");
        }        
        
        System.out.println(formatter.format(now.getTime()) + " : image capture was succeed.");
        
    }
    
    public boolean findProcessByName(String processName) {
        try {            
            String process;
            // getRuntime: Returns the runtime object associated with the current Java application.
            // exec: Executes the specified string command in a separate process.
            Process p = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                process = process.toLowerCase();
                System.out.println(process); // <-- Print all Process here line by line
                if (process.contains(processName.toLowerCase())) {
                    return true;
                }
            }
            input.close();
        } catch (Exception err) {
                err.printStackTrace();
        }
        
        return false;
    }
    
    public void printLog(String strMsg) {
        String old = mMainForm.getLogText();
        String newLog = old + "\n" + strMsg + "\n";        
        mMainForm.setLogText(newLog);
    }
    
}
