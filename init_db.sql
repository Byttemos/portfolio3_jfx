--run this script with the command $sqlite3 data.db < init_db.sql
.separator ','
.import students_data.csv Students
.import city_data.csv Cities
.import registrations_data.csv Registrations
.import Courses_data.csv Courses
UPDATE Registrations SET Grade = null WHERE Grade = 'NULL'