# C/C++

Visual Studio 2013

[Install Extension](https://msdn.microsoft.com/en-us/library/vstudio/dd293639(v=vs.100).aspx)

[VsVim](https://visualstudiogallery.msdn.microsoft.com/59ca71b3-a4a3-46ca-8fe1-0e90e3f79329)


[googletest](https://code.google.com/p/googletest/) <small>[guide](http://www.bogotobogo.com/cplusplus/google_unit_test_gtest.php)</small>

### Folder Structure

with VS 2013

```
solution
│   README.md
│
|───project1
|   │   file011.txt
|   │   file012.txt
|   │
|───project2
|   │   file011.txt
|   │   file012.txt
|   │
```

Format: `Ctrl + K, Ctrl + D`

### C++ Style

[wonderplugin_slider id="5"]

<div style="clear:both; height:80px;"></div>

### Tools

<table>
<tbody>
<tr>
<td style="text-align:center;width:33%;">
<img src="http://icons.iconarchive.com/icons/graphicloads/polygon/32/book-icon.png"/>
Documentation
</td>
<td style="text-align:center;width:33%;">
<img src="http://icons.iconarchive.com/icons/apathae/wren/32/Utilities-icon.png"/>
IDE</td>
<td style="text-align:center;width:33%;">
</td>
</tr>
<tr>
<td style="text-align:center;">
<a href="http://www.cprogramming.com/tutorial.html">Programming Tutorials</a></td>
</td>
<td style="text-align:center;">
<a href="https://www.jetbrains.com/clion/">Clion</a>, <a href="https://www.visualstudio.com/en-us/downloads/download-visual-studio-vs.aspx">Visual Studio</a>
</td>
<td style="text-align:center;">
</tr>
</tbody>
</table>

<br/>

<table>
<tbody>
<tr>
<td style="text-align:center;width:33%;"><img src="https://cdn2.iconfinder.com/data/icons/ballicons-2-free/100/wrench-32.png" alt="" />
Build Tool</td>
<td style="text-align:center;width:33%;"><img src="http://icons.iconarchive.com/icons/graphicloads/polygon/32/check-2-icon.png" />
Test</td>
<td style="text-align:center;width:33%;"><img src="http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/32/Mimetypes-text-x-log-icon.png" />
Logging</td>
</tr>
<tr>
<td style="text-align:center;"><a href="" target="_blank"></a></td>
<td style="text-align:center;">
<a href="https://code.google.com/p/googletest/" target="_blank">Google Test</a>,
<a href="https://github.com/evolutional/Chamois" target="_blank">Chamois</a>,
<a href="https://www.visualstudio.com/en-us/get-started/code/create-and-run-unit-tests-vs" target="_blank">VS UnitTest</a>
</td>
<td style="text-align:center;">
</tr>
</tbody>
</table>

# C++: 101

# 1. Installation

* Install Visual Studio 2013

# 2. Hello World

```cpp
#include <iostream>
using namespace std;

int main() {
    cout << "hello world";
}
```

# C++: Use C++

## 1. Naming [^1]

```
variable_name_like_this
class_data_memeber_name_like_this_
kConstantNamesLikeThis
ClassNameLikeThis
filenamelikethis_myusefulclass_test.cc
```

## 2. Comment [^1]

### 2.1 Class Comment

```cpp
// Iterates over the contents of a GargantuanTable.
// Example:
//    GargantuanTableIterator* iter = table->NewIterator();
//    for (iter->Seek("foo"); !iter->done(); iter->Next()) {
//      process(iter->key(), iter->value());
//    }
//    delete iter;
class GargantuanTableIterator {
  ...
};
```

### 2.2 Todo Comment

```cpp
// TODO(kl@gmail.com): Use a "*" here for concatenation operator.
// TODO(Zeke) change this to use relations.
```

[^1]: [Google C++ Style Guide](https://google.github.io/styleguide/cppguide.html#Naming)

# C++: Data Structure

## Stack

## Quote

## Linked List

## Graph


## Array

## Deque

## Forward_list

## List

http://www.slideshare.net/sshinchan/single-linked-list

# Map

# Set

# Stack

# unordered_map

# unordered_set

# vector

# datetime

http://www.tutorialspoint.com/cplusplus/cpp_date_time.htm

# C++: String

# String Basic[^1]

```cpp
#include <iostream>
#include <string>
using namespace std ;

// assign a string
string s1 = "www.java2s.com\n";
cout << s1;

// input a string
string s2;
cin >> s2;

// concatenate two strings
string s_c = s1 + s2;

// compare strings
s1 == s2;
```

[^1]: [Define a string variable, assign a value and display it : string « string « C++ Tutorial](http://www.java2s.com/Tutorial/Cpp/0300__string/Defineastringvariableassignavalueanddisplayit.htm)

# C++: Pointer

## Pointer [^1]

A pointer is a variable whose value is the address of another variable. Like any variable or constant, you must declare a pointer before you can work with it.

The general form of a pointer variable declaration is:

```cpp
type *variable_name;
// example
int    *ip;    // pointer to an integer
double *dp;    // pointer to a double
float  *fp;    // pointer to a float
char   *ch;    // pointer to character
```

# Pointer Lab

![](https://lh3.googleusercontent.com/MUzBdLRGuwilV16MBABqQtCHj71elA305jtDHBy8wSIMMYkIcqds=w213-h219-no)

```cpp
#include <iostream>
using namespace std;

/*
 * Look at these lines
 */
int* a;
a = new int[3];
a[0] = 10;
a[1] = 2;
cout << "Address of pointer a: &a = " << &a << endl;
cout << "Value   of pointer a:  a = " << a << endl << endl;
cout << "Address of a[0]: &a[0] = " << &a[0] << endl;
cout << "Value   of a[0]: a[0]  = " << a[0]  << endl;
cout << "Value   of a[0]: *a    = " << *a    << endl << endl;
cout << "Address of a[1]: &a[1] = " << &a[1] << endl;
cout << "Value   of a[1]: a[1]  = " << a[1]  << endl;
cout << "Value   of a[1]: *(a+1)= " << *(a+1)<< endl << endl;
cout << "Address of a[2]: &a[2] = " << &a[2] << endl;
cout << "Value   of a[2]: a[2]  = " << a[2]  << endl;
cout << "Value   of a[2]: *(a+2)= " << *(a+2)<< endl << endl;
```

Result:

[code lang="text"]
Address of pointer a: &a = 008FF770
Value   of pointer a:  a = 00C66ED0

Address of a[0]: &a[0] = 00C66ED0
Value   of a[0]: a[0]  = 10
Value   of a[0]: *a    = 10

Address of a[1]: &a[1] = 00C66ED4
Value   of a[1]: a[1]  = 2
Value   of a[1]: *(a+1)= 2

Address of a[2]: &a[2] = 00C66ED8
Value   of a[2]: a[2]  = -842150451
Value   of a[2]: *(a+2)= -842150451
```

```cpp
/*
 * ? How about this
 */
a[3] = 8;
// it will throw some think like this
// Stack around the variable 'a' was corrupted.
```

[^1]: [C++ Pointers: tutorialspoint](http://www.tutorialspoint.com/cplusplus/cpp_pointers.htm)

# C++: OOP

![](http://wearelaunchbox.com/wp-content/uploads/2012/11/oop-basics.png)

<h3>Classes and Objects</h3>

<script src="http://ideone.com/e.js/l18265" type="text/javascript" ></script>

# C++: Template

### Function Template

```cpp
#include <iostream>
#include <string>

using namespace std;

template <typename T>

T Max(T a, T b)
{
	return a < b ? b : a;
}

int main()
{

	int i = 39;
	int j = 20;
	cout << Max(i, j) << endl;

	double f1 = 13.5;
	double f2 = 20.7;
	cout << Max(f1, f2) << endl;

	string s1 = "Hello";
	string s2 = "World";
	cout << Max(s1, s2) << endl;

	double n1 = 20.3;
	float n2 = 20.4;
	// it will show an error
	// Error: no instance of function template "Max" matches the argument list
	//        arguments types are: (double, float)
	cout << Max(n1, n2) << endl;
	return 0;
}
```

# C++: Test

# 1. Create Unit Test in Visual Studio 2013

### Step 1. Create `TDDLab` Solution

**1.1** Open Visual Studio 2013

**1.2** `File` ->  `New Project...` ->

* Click `Visual C++` -> `Win32`

* Choose `Win32 Console Application`

* Fill to `Name` input text: **TDDLab**

* Click `OK` -> `Next`

**1.3** In project settings, remove options:

* `Precompiled Header`
* `Securirty Develoment Lifecyde(SQL) check`

**1.4** Click `Finish`

### Step 2. Create `Counter` Class

**2.1** Right-click `TDDLab` -> `Add` -> `Class...`

**2.2** Choose `Visual C++` -> `C++ Class` -> `Add`

**2.3** Fill in `Class name` box **Counter** -> `Finish`

**2.4** In `Counter.h` file, add this below function

```cpp
int add(int a, int b);
```

**2.5** In `Counter.cpp`, add this below function

```cpp
int Counter::add(int a, int b) {
  return a+b;
}
```

Your `Counter` class should look like this

![](https://lh3.googleusercontent.com/MeGn9mLmTTdYtcc-F1HeS7cm5v5QhmmLpPKa35QUeIqDOaKWHhqHlYZilL-sDIFH4993R0dgck4ZfQ=w745-h434-no)

### Step 3. Create `TDDLabTest` Project

**3.1** Right-click `Solution 'TDDLab'` -> `Add` -> `New Project...`

**3.2** Choose `Visual C++` -> `Test`

**3.3** Choose `Native Unit Test Project`

**3.4** Fill to `Name` input text: **TDDLabTest**

### Step 4. Write unit test

**4.1**  In `unittest1.cpp`, add header of `Counter` class

```cpp
#include "../TDDLab/Counter.h"
```

**4.2** In `TEST_METHOD` function

```cpp
{
  Counter counter;
  Assert::AreEqual(2, counter.add(1, 1));
}
```

**4.3** Click `TEST` in menu bar -> `Run` -> `All Test (Ctrl + R, A)

### Step 5. Fix error `LNK 2019: unresolved external symbol`

**5.1** Change `Configuration Type` of `TDDLab` project

* Right click  `TDDLab` project -> `Properties`
* `General` -> `Configuration Type` -> `Static library (.lib)` -> `OK`

**5.2** Add Reference to `TDDLabTest` project

* Right click `TDDLabTest` solution -> `Properties` -> `Common Properties` -> `Add New Reference `
* Choose `TDDLab` -> `OK` -> `OK`

### Step 6. Run Tests

Click `TEST` in menu bar -> `Run` -> `All Test (Ctrl + R, A)

Test should be passed.

![](https://lh3.googleusercontent.com/OePw8s2rRtk1ygSbCyOOGx7TQAL1tiJoE4cBM1_YTtauTP4Gcb0KhsR9PWInbAxaGLJDg8W7HsDumQ=w747-h434-no)

# 2. Assertion Frameworks

* [Microsoft.VisualStudio.TestTools.CppUnitTestFramework](https://msdn.microsoft.com/en-us/library/hh694604.aspx)
* [evolutional/Chamois](https://github.com/evolutional/Chamois)

# 3. Test Frameworks

* [googletest](https://github.com/google/googletest)

# C++: IDE

![](http://i0.wp.com/venturebeat.com/wp-content/uploads/2014/11/visual_studio_2010_logo.png?fit=930%2C9999)

## Visual Studio

### Content

```
├── 1. Create new project
├── 2. Search & Replace
├── 3. Navigation
├── 4. Formatting
├── 5. Debugging
├── 6. Build & Release
└── 7. Git Integration
```

## 4. Formatting

```
Ctrl + K / Ctrl + F
Ctrl + F / Ctrl + D
```

## 6. Git in Visual Studio

[https://git-scm.com/book/en/v2/Git-in-Other-Environments-Git-in-Visual-Studio](https://git-scm.com/book/en/v2/Git-in-Other-Environments-Git-in-Visual-Studio)

# Online IDE

* [codechef ide](https://www.codechef.com/ide)

# C++: Database

### Sqlite with Visual Studio 2013

**Step 1**: Create new project
1.1 Create a new C++ Win32 Console application.

**Step 2:** Download Sqlite DLL

2.1. Download the native SQLite DLL from: http://sqlite.org/sqlite-dll-win32-x86-3070400.zip
2.2. Unzip the DLL and DEF files and place the contents in your project’s source folder (an easy way to find this is to right click on the tab and click the “Open Containing Folder” menu item.

**Step 3:** Build LIB file

3.1. Open a “Developer Command Prompt” and navigate to your source folder. (If you can't find this tool, follow this post in stackoverflow [Where is Developer Command Prompt for VS2013?](http://stackoverflow.com/questions/21476588/where-is-developer-command-prompt-for-vs2013) to create it)
3.2. Create an import library using the following command line: LIB /DEF:sqlite3.def

**Step 4:** Add Dependencies

4.1. Add the library (i.e. sqlite3.lib) to your Project Properties -> Configuration Properties -> Linker -> Input -> Additional Dependencies.
4.2. Download http://sqlite.org/sqlite-amalgamation-3070400.zip
4.3. Unzip the sqlite3.h header file and place into your source directory.
4.4. Include the the sqlite3.h header file in your source code.
4.5. You will need to include the sqlite3.dll in the same directory as your program (or in a System Folder).

**Step 5:** Run test code

```cpp
#include "stdafx.h"
#include <ios>
#include <iostream>
#include "sqlite3.h"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
   int rc;
   char *error;

   // Open Database
   cout << "Opening MyDb.db ..." << endl;
   sqlite3 *db;
   rc = sqlite3_open("MyDb.db", &db);
   if (rc)
   {
      cerr << "Error opening SQLite3 database: " << sqlite3_errmsg(db) << endl << endl;
      sqlite3_close(db);
      return 1;
   }
   else
   {
      cout << "Opened MyDb.db." << endl << endl;
   }

   // Execute SQL
   cout << "Creating MyTable ..." << endl;
   const char *sqlCreateTable = "CREATE TABLE MyTable (id INTEGER PRIMARY KEY, value STRING);";
   rc = sqlite3_exec(db, sqlCreateTable, NULL, NULL, &error);
   if (rc)
   {
      cerr << "Error executing SQLite3 statement: " << sqlite3_errmsg(db) << endl << endl;
      sqlite3_free(error);
   }
   else
   {
      cout << "Created MyTable." << endl << endl;
   }

   // Execute SQL
   cout << "Inserting a value into MyTable ..." << endl;
   const char *sqlInsert = "INSERT INTO MyTable VALUES(NULL, 'A Value');";
   rc = sqlite3_exec(db, sqlInsert, NULL, NULL, &error);
   if (rc)
   {
      cerr << "Error executing SQLite3 statement: " << sqlite3_errmsg(db) << endl << endl;
      sqlite3_free(error);
   }
   else
   {
      cout << "Inserted a value into MyTable." << endl << endl;
   }

   // Display MyTable
   cout << "Retrieving values in MyTable ..." << endl;
   const char *sqlSelect = "SELECT * FROM MyTable;";
   char **results = NULL;
   int rows, columns;
   sqlite3_get_table(db, sqlSelect, &results, &rows, &columns, &error);
   if (rc)
   {
      cerr << "Error executing SQLite3 query: " << sqlite3_errmsg(db) << endl << endl;
      sqlite3_free(error);
   }
   else
   {
      // Display Table
      for (int rowCtr = 0; rowCtr <= rows; ++rowCtr)
      {
         for (int colCtr = 0; colCtr < columns; ++colCtr)
         {
            // Determine Cell Position
            int cellPosition = (rowCtr * columns) + colCtr;

            // Display Cell Value
            cout.width(12);
            cout.setf(ios::left);
            cout << results[cellPosition] << " ";
         }

         // End Line
         cout << endl;

         // Display Separator For Header
         if (0 == rowCtr)
         {
            for (int colCtr = 0; colCtr < columns; ++colCtr)
            {
               cout.width(12);
               cout.setf(ios::left);
               cout << "~~~~~~~~~~~~ ";
            }
            cout << endl;
         }
      }
   }
   sqlite3_free_table(results);

   // Close Database
   cout << "Closing MyDb.db ..." << endl;
   sqlite3_close(db);
   cout << "Closed MyDb.db" << endl << endl;

   // Wait For User To Close Program
   cout << "Please press any key to exit the program ..." << endl;
   cin.get();

   return 0;
}
```
