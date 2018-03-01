/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.utils;

import com.circuit.main.RegisterController;
import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

/**
 *
 * @author Marvin
 */
public class WebcamInitialize {

    public static Task<Void> webCamTask;
     public boolean stopCamera;
    public Webcam BCwebcam = null;
    public Webcam WCWebcam = null;
    public Thread webCamThread;
        private final ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    
    
    public void initializeWebCam(ImageView profilePic, ImageView WCProfilePicId) {
      
   
             webCamTask = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                

                
                BCwebcam = Webcam.getDefault();
                WCWebcam = Webcam.getDefault();
                BCwebcam.open();
                WCWebcam.open();

                
            
                      
                startWebCamStream(profilePic);
                startWCCamStream(WCProfilePicId);
                
              
                return null;

            }
        };
       
        
        
    
        webCamThread = new Thread(webCamTask);
        webCamThread.setDaemon(true);
        webCamThread.start();
        System.out.println("active thread count: " + webCamThread.activeCount());

    }
    
     public ImageView startWebCamStream(ImageView profilePicId) throws InterruptedException {
         stopCamera = false;

            webCamTask = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				final AtomicReference<WritableImage> ref = new AtomicReference<>();
				BufferedImage img = null;

				while (!stopCamera) {
					try {
						if ((img = BCwebcam.getImage()) != null) {

							ref.set(SwingFXUtils.toFXImage(img, ref.get()));
							img.flush();

							Platform.runLater(new Runnable() {

								@Override
								public void run() {
									imageProperty.set(ref.get());
								}
							});
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				return null;
			}
		};
            
                            
		Thread th = new Thread(webCamTask);
		th.setDaemon(true);
		th.start();
		profilePicId.imageProperty().bind(imageProperty);
      
        
                 return profilePicId;
            

		
         
            


	}
     
     public ImageView startWCCamStream(ImageView WCProfilePic)throws InterruptedException 
    {   
        stopCamera = false;
		webCamTask = new Task<Void>() {
                    
			@Override
			protected Void call() throws Exception {

				final AtomicReference<WritableImage> ref = new AtomicReference<>();
				BufferedImage img = null;

				while (!stopCamera) {
					try {
						if ((img = WCWebcam.getImage()) != null) {

							ref.set(SwingFXUtils.toFXImage(img, ref.get()));
							img.flush();

							Platform.runLater(new Runnable() {

								@Override
								public void run() {
									imageProperty.set(ref.get());
								}
							});
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				return null;
			}
		};
                
		Thread th = new Thread(webCamTask);
		th.setDaemon(true);
		th.start();
		WCProfilePic.imageProperty().bind(imageProperty);
        return WCProfilePic;
    }
    
}
