import face_recognition
import os
import numpy as np

# Create a list to hold the embeddings
embeddings_list = []
user_names = []

# Path to the dataset
dataset_path = 'dataset/'

# Loop through each user's images
for user in os.listdir(dataset_path):
    user_folder = os.path.join(dataset_path, user)
    if os.path.isdir(user_folder):  # Check if it's a directory
        user_names.append(user)
        for image_file in os.listdir(user_folder):
            image_path = os.path.join(user_folder, image_file)
            image = face_recognition.load_image_file(image_path)
            encoding = face_recognition.face_encodings(image)
            if encoding:  # Check if encoding is found
                embeddings_list.append(encoding[0])  # Add the first encoding found

# Save embeddings to a text file
np.savetxt("embeddings/embeddings.txt", embeddings_list, delimiter=',')
with open("embeddings/user_names.txt", 'w') as f:
    for name in user_names:
        f.write(name + "\n")

print("Embeddings saved successfully.")
