package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Builder
public class WordList {
    public static List<String> Words;
    public static List<String> ReportNames;
    public static List<String> AssetNames;

    static {
        AssetNames = Arrays.asList(
                "file_1.txt",
                "file_2.txt",
                "file_3.txt",
                "file_4.txt",
                "file_5.txt",
                "file_6.txt",
                "file_7.txt",
                "file_8.txt",
                "file_9.txt",
                "file_10.txt",
                "file_11.txt",
                "file_12.txt",
                "file_13.txt",
                "file_14.txt",
                "report.pdf",
                "customer_data.csv",
                "presentation.ppt",
                "invoice.xlsx",
                "budget.xls",
                "screenshot.png",
                "image.jpg",
                "document.docx",
                "spreadsheet.xlsx",
                "photo.png",
                "chart.ppt",
                "asset_1.txt",
                "asset_2.pdf",
                "asset_3.docx",
                "asset_4.jpg",
                "asset_5.png",
                "asset_6.xlsx",
                "asset_7.csv",
                "asset_8.mp3",
                "asset_9.mp4",
                "asset_10.avi",
                "asset_11.mov",
                "asset_12.ppt",
                "asset_13.pptx",
                "asset_14.zip",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_2ff9c5e5-a839-4fbc-86bd-1bed753834b9.csv",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_3d1e7c2d-a822-4ef1-98bc-23fbcb6e69ee.pdf",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_4b5f9d17-a8a2-4acd-aa45-34dcc8b6e234.docx",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_2ff9c5e5-a839-4fbc-86bd-1bed753834b9.csv",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_2ff9c5e5-a839-4fbc-86bd-1bed753834b9.pdf",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_2ff9c5e5-a839-4fbc-86bd-1bed753834b9.docx",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_2ff9c5e5-a839-4fbc-86bd-1bed753834b9.jpg",
                "https://uedlabsqabluezone.blob.core.windows.net/f33a635d-9bdd-4a09-b219-34c6f613cd86/assetName_2ff9c5e5-a839-4fbc-86bd-1bed753834b9.png"
        );
    }

    static {
        Words = Arrays.asList(
                "Levy",
                "Duty",
                "Tariff",
                "Excise",
                "Customs",
                "Import",
                "Export",
                "Value-added",
                "Sales",
                "Use",
                "Property",
                "Inheritance",
                "Gift",
                "Payroll",
                "Income",
                "Capital gains",
                "Corporate",
                "Self-employment",
                "Social security",
                "Medicare",
                "Excise",
                "Franchise",
                "Excise",
                "Ad valorem",
                "Sales tax",
                "Business tax",
                "Excise tax",
                "Consumption tax",
                "Luxury tax",
                "Sin tax",
                "Flat tax",
                "Progressive tax",
                "Regressive tax",
                "Tax rate",
                "Tax bracket",
                "Tax base",
                "Tax credit",
                "Tax deduction",
                "Tax exemption",
                "Tax shelter",
                "Tax evasion",
                "Tax fraud",
                "Tax haven",
                "Tax avoidance",
                "Tax relief",
                "Tax refund",
                "Tax lien",
                "Tax levy",
                "Tax notice",
                "Tax assessment",
                "Tax return",
                "Tax 5060deadline",
                "Tax forms",
                "Tax accountant",
                "Tax attorney",
                "Tax preparation",
                "Tax planning",
                "Tax audit",
                "Tax appeal",
                "Tax settlement",
                "Tax collection",
                "Tax law",
                "Tax code",
                "Tax policy",
                "Tax reform",
                "Tax system",
                "Taxation",
                "Fiscal policy",
                "Budget",
                "Deficit",
                "Debt",
                "Revenue",
                "Expenditure",
                "Surplus",
                "Burden",
                "Fairness",
                "Equity",
                "Justice",
                "Document",
                "Spreadsheet",
                "Presentation",
                "Text",
                "Image",
                "Audio",
                "Video",
                "Archive",
                "Database",
                "PDF",
                "CSV",
                "Excel",
                "Word",
                "PowerPoint",
                "HTML",
                "ZIP",
                "RAR",
                "Executable",
                "Script",
                "Configuration",
                "Log",
                "Backup",
                "Encrypted",
                "Compressed",
                "Shared",
                "Collaborative",
                "Protected",
                "Private",
                "Public",
                "Read-only",
                "Editable",
                "Writeable",
                "Viewable",
                "Printable",
                "Downloadable",
                "Uploadable",
                "Syncable",
                "Versioned",
                "Timestamped",
                "Tagged",
                "Indexed",
                "Searchable",
                "Sortable",
                "Filtered",
                "Formatted",
                "Annotated",
                "Commented",
                "Described",
                "Named",
                "Titled",
                "Labeled",
                "Filed",
                "Stored",
                "Retrieved",
                "Deleted",
                "Moved",
                "Copied",
                "Pasted",
                "Cut",
                "Undo",
                "Redo",
                "Save",
                "Save As",
                "Save Copy",
                "Save Version",
                "Save Backup",
                "Open",
                "Close",
                "Quit",
                "Exit",
                "Restart",
                "Shutdown",
                "Update",
                "Upgrade",
                "Install",
                "Uninstall",
                "Enable",
                "Disable",
                "Repair",
                "Fix",
                "Troubleshoot",
                "Optimize",
                "Clean",
                "Secure",
                "Protect",
                "Defend",
                "Scan",
                "Monitor",
                "Audit",
                "Analyze",
                "Inspect",
                "Validate",
                "Test",
                "Verify",
                "Certify",
                "Accredit",
                "Authorize",
                "Approve",
                "Reject",
                "Deny",
                "Block",
                "Quarantine",
                "Isolate",
                "Recover",
                "Restore",
                "Resolve",
                "Confirm",
                "Dismiss",
                "Ignore",
                "Cancel",
                "Interrupt",
                "Pause",
                "Resume",
                "Abort",
                "Stop",
                "Wait",
                "Continue",
                "Start",
                "Begin",
                "End",
                "Complete",
                "Finish",
                "Submit",
                "Retry",
                "Revert",
                "Redirect",
                "Exit",
                "Return",
                "Clear",
                "Reset",
                "Refresh",
                "beautiful",
                "elegant",
                "exquisite",
                "gorgeous",
                "graceful",
                "magnificent",
                "majestic",
                "luxurious",
                "opulent",
                "refined",
                "sumptuous",
                "charming",
                "delightful",
                "enchanting",
                "lovely",
                "pleasing",
                "alluring",
                "appealing",
                "attractive",
                "beguiling",
                "captivating",
                "enticing",
                "fascinating",
                "irresistible",
                "seductive",
                "tempting",
                "breathtaking",
                "dazzling",
                "impressive",
                "jaw-dropping",
                "stunning",
                "awe-inspiring",
                "majestic",
                "magnificent",
                "grand",
                "imposing",
                "impressive",
                "splendid",
                "monumental",
                "towering",
                "colossal",
                "gigantic",
                "towering",
                "monstrous",
                "gargantuan",
                "immense",
                "giant",
                "enormous"
        );
    }
    static {
        ReportNames = Arrays.asList(
                "The Executive Summary",
                "The Sales Dashboard",
                "The Marketing Report",
                "The Financial Summary",
                "The Operational Overview",
                "The Customer Insights",
                "The Project Status",
                "The Performance Metrics",
                "The Revenue Analysis",
                "The Cost Breakdown",
                "The Budget Forecast",
                "The Inventory Report",
                "The Employee Analysis",
                "The Productivity Dashboard",
                "The Customer Acquisition",
                "The Customer Retention",
                "The Customer Satisfaction",
                "The Social Media Insights",
                "The Website Traffic Report",
                "The SEO Analysis",
                "The PPC Performance",
                "The Email Marketing Report",
                "The Advertising Analysis",
                "The Public Relations Summary",
                "The Brand Reputation Report",
                "The Competitive Analysis",
                "The Market Research Insights",
                "The Industry Trends",
                "The SWOT Analysis",
                "The Risk Assessment",
                "The Project Management Dashboard",
                "The Task Progress Report",
                "The Resource Allocation",
                "The Quality Assurance Report",
                "The Issue Tracking Dashboard",
                "The Change Management Log",
                "The Time Tracking Report",
                "The Schedule Overview",
                "The Budget vs Actuals",
                "The Workload Analysis",
                "The Capacity Planning",
                "The SLA Compliance",
                "The Service Level Report"
        );
    }

    public static String generateSampleDescription(){
        Random random = new Random();

        // Use a StringBuilder to build the description
        StringBuilder descriptionBuilder = new StringBuilder();

        // Add a random number of words to the description
        int numWords = random.nextInt(30) + 3;
        for (int n = 0; n < numWords; n++) {
            // Generate a random number within the range of the size of the list of words
            int randomIndex = random.nextInt(Words.size());

            // Use the random number as the index to select a word from the list
            String word = Words.get(randomIndex);

            // Append the word to the description
            descriptionBuilder.append(word);

            // Add a space after the word, unless it's the last word
            if (n < numWords - 1) {
                descriptionBuilder.append(" ");
            }
        }
        String description = descriptionBuilder.toString();
        return description;
    }

    public static String generateRandomReportName(){
        String reportName = "";
        Random random = new Random();
        int randomIndex = random.nextInt(ReportNames.size());

        reportName = ReportNames.get(randomIndex);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567980";
        int indexLetter = random.nextInt(alphabet.length());
        reportName = reportName + " : " + alphabet.substring(indexLetter);

        return reportName;
    }
    public static String generateRandomAssetName(){
        String assetName = "";
        Random random = new Random();
        int randomIndex = random.nextInt(AssetNames.size());

        assetName = AssetNames.get(randomIndex);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567980";
        int indexLetter = random.nextInt(alphabet.length());
        assetName =  alphabet.substring(indexLetter)+ " : " + assetName;

        return assetName;
    }
}
