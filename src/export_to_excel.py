
import pandas as pd
import json
import os

# Load the attendance log from the JSON file
if os.path.exists('attendance.json'):
    with open('attendance.json', 'r') as f:
        attendance_log = json.load(f)  # Load existing attendance data

    # Convert the attendance log to a Pandas dataframe
    df = pd.DataFrame(attendance_log.items(), columns=['Name', 'Timestamp'])

    # Write the attendance data to an Excel file
    df.to_excel('attendance_log.xlsx', index=False)  # Save as Excel without row index
    print("Attendance log exported to 'attendance_log.xlsx'.")
else:
    print("Attendance log file not found.")

