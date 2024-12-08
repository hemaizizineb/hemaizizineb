import cv2

# Initialize the camera (0 = default camera)
cap = cv2.VideoCapture(0)

# Capture and display the video feed
while True:
    ret, frame = cap.read()  # Capture frame-by-frame
    cv2.imshow("Camera Feed", frame)  # Show the captured frame
    
    # Press 'q' to quit the video stream
    if cv2.waitKey(1) == ord('q'):
        break

# Release the camera and close the window
cap.release()
cv2.destroyAllWindows()
