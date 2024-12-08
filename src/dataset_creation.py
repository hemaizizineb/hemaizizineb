import cv2
import os

# Initialize the camera
cap = cv2.VideoCapture(0)

# Create a dataset directory if not exists
if not os.path.exists("dataset"):
    os.makedirs("dataset")

# Ask user for ID or Name (to store images for each person)
user_id = input("Enter user ID or name: ")
user_folder = os.path.join("dataset", user_id)

if not os.path.exists(user_folder):
    os.makedirs(user_folder)

# Counter for image naming
count = 0

# Capture multiple images
while True:
    ret, frame = cap.read()
    cv2.imshow("frame", frame)
    
    # Press 's' to save an image
    if cv2.waitKey(1) == ord('s'):
        count += 1
        filename = os.path.join(user_folder, f"image_{count}.jpg")
        cv2.imwrite(filename, frame)
        print(f"Image {count} saved.")
        
    # Press 'q' to exit
    if cv2.waitKey(1) == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
