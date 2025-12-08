class Solution {

    public int numUniqueEmails(String[] emails) {
        java.util.Set<String> uniqueEmails = new java.util.HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // Remove everything after '+' in the local part
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // Remove all '.' from the local part
            local = local.replace(".", "");

            // Reconstruct the cleaned email
            String cleanedEmail = local + "@" + domain;
            uniqueEmails.add(cleanedEmail);
        }

        return uniqueEmails.size();


    }
}