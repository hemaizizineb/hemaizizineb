import cv2
import os

# Path to the dataset containing images
dataset_path = 'dataset/'  # Update this path as needed

# Check if the output directory exists; if not, create it
output_path = 'processed_images/'
os.makedirs(output_path, exist_ok=True)

# Loop through each user folder in the dataset
for user_folder in os.listdir(dataset_path):
    user_path = os.path.join(dataset_path, user_folder)  # Full path to user folder
    if os.path.isdir(user_path):  # Check if it's a directory
        # Loop through each image in the user's folder
        for image_file in os.listdir(user_path):
            image_path = os.path.join(user_path, image_file)  # Full path to image
            # Load the image
            img = cv2.imread(image_path)

            if img is not None:  # Ensure the image was loaded correctly
                # Convert the image to grayscale
                gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

                # Apply Gaussian blur to the grayscale image
                blur = cv2.GaussianBlur(gray, (5, 5), 0)

                # Apply adaptive thresholding
                thresh = cv2.adaptiveThreshold(blur, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY_INV, 11, 2)

                # Apply morphological operations
                kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (3, 3))
                dilate = cv2.dilate(thresh, kernel, iterations=3)
                erode = cv2.erode(dilate, kernel, iterations=3)

                # Save the preprocessed image to the output directory
                processed_image_path = os.path.join(output_path, f"{user_folder}_{image_file}")
                cv2.imwrite(processed_image_path, erode)

                # Optional: Display the preprocessed image
                cv2.imshow("Preprocessed Image", erode)
                cv2.waitKey(100)  # Display each image for a short duration

# Cleanup: close all OpenCV windows
cv2.destroyAllWindows()
print("Image preprocessing complete. Processed images saved to:", output_path)
