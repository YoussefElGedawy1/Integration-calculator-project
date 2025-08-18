# 🧮 Calculator Integration Project  

An integration project developed during my internship at **Saib IT**, showcasing how to orchestrate data flow between applications using **IBM App Connect Enterprise (ACE)**. The system demonstrates **file processing**, **SOAP services**, **REST APIs**, and **schema validation** to automate mathematical operations.  

---

## 🚀 Features  
- JavaFX desktop app for user input.  
- File-based communication with structured data parsing (DFDL).  
- Custom **SOAP Calculator Service** for arithmetic operations.  
- **JSON validation** and statistics aggregation.  
- **REST API** for operator usage reporting.  
- Shared libraries for reusability.  

---

## 🛠️ Applications  

### 1. JavaFX UI  
- Collects math expressions (e.g., `7 * 9`).  
- Saves input in a structured text file.  
- ⚠️ Update the file path in the Java code before running.  

---

### 2. FileReader (ACE Flow)  
- Reads and parses input files using **DFDL schema**.  
- Calls the Calculator Service via **SOAP (WSDL)**.  
- Outputs results into a **JSON file**.  

---

### 3. Calculator Service (ACE, SOAP)  
- Built with **SOAPInput → Compute → SOAPReply** nodes.  
- Performs arithmetic operations.  
- Publishes a **WSDL endpoint** (testable in SOAP UI).  

---

### 4. Operator Aggregator (ACE, REST)  
- Reads the JSON results from FileReader.  
- Validates with a **JSON Schema**.  
- Counts how many times each operator was used.  
- Exposes a **REST GET endpoint** (testable with Postman).  

---

## 🔄 Workflow  

```plaintext
JavaFX UI → Structured Input File
       ↓
FileReader (ACE)
   • Parse with DFDL
   • Call Calculator (SOAP)
   • Save result as JSON
       ↓
Calculator Service (SOAP, ACE)
   • Perform operation
   • Return result
       ↓
Operator Aggregator (ACE)
   • Validate JSON
   • Count operator usage
   • Expose REST GET
