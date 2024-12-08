A smart attendance system using python .
dataset folder will be created auto and a folder for each user images 
embeddings folder created auto in the same way
and a processed images folder + a an excel file contain the attendace record.below is project structure and guide.

Smart attendance management system:
A face detection attendance system build with pyhon programming language and Facial recognition technology .

**Requirements:**
- webcam resolution up to 720 to capture clear images
- Python IDE , OpenCV Face_recognition and NumPy libraries
- face recognition algorithm (reconize/detect  faces and extract facial features )
- Attendance management by manage records for each person (time and date)
  
Build project:

Smart_Attendance_management_system/
│
├── dataset/ #folder to store captured images for each user
│   ├── user1 folder
│   ├── user2 folder
│   ├── ...
│   │  #more folder image for recognition and teraining
│
├── embeddings/ # folder to store face embeddings(computed face features)
│   ├── embeddings.txt    #file containing face embeddings of users 
│
├── attendance.json #JSON file to store attendace log(auto created if not present)
├── attendace_log.xlsx #Excel file where attendance data is written auto
└── src/ #source code obviously contain all python scripts

│   ├── camera_capture.py #py script for initial data acquisition from the webcam
│   ├── image_preprocessing.py             # image preprocessing (grayscale conversion, thresholding)
│   ├── dataset_creation.py #capture images for users
│   ├── face_embeddings.py #generate and save face embeddings
│   ├──attendance_system.py #Main face recognition and attendance system script
│   ├──export_to_excel.py #export attendace log to Excel file
│   ├──requirements.txt 

Order of commands: 
step1:  dataset_creation.py (Capture images+user id or name for folder creation)
step2:  image_processing.py (optional process images)
step3:  face_embeddings.py (Generate face embeddings)
step4: attendance_system.py (Run attendamce system)
step5:   export_to_excel.py (Expor attendance to excel)





