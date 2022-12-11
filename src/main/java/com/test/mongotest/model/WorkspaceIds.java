package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
public class WorkspaceIds {
    public static List<String> Ids;

    static {
        Ids = Arrays.asList(
                "aaf8f838-2fde-4aac-afed-e36fc9e43af1",
                "c7773741-0f69-4681-acfa-63aba74c8996",
                "5f6c2cba-13de-47ae-8a9e-2799f6372c15",
                "cd79dd6f-b2a0-4171-85e8-07cb338f6f89",
                "a8afce2b-b9be-4f25-b6e3-a05bfbbc9ed3",
                "fb79e0a9-6dc3-475f-90d8-868956b27f6b",
                "7f065ee9-122c-4753-8154-070a26ca4d3d",
                "3b603b29-1961-47db-80ad-d8b79b95ba7f",
                "63f394e4-af5b-4cda-8fda-39d61eb926a9",
                "337fed29-68ab-4436-ab52-a119bbd97928",
                "78faed28-e4bb-44f5-9bfa-406ba891f707",
                "2e40e6b6-8b52-42bf-9f26-5fa0c726c3bf",
                "6479b95a-12b0-4707-8946-1f543502e384",
                "8ab289ad-c56b-4fc5-bbad-ea609d171ae9",
                "0f40c856-9777-4a58-9f0e-c7e1ff20bdc3",
                "171d452c-9c7a-4dab-bfc3-8e936f26202c",
                "ea56102f-ee6e-4480-bc77-fd7b7a5ce9d4",
                "9bb6eea5-a9e0-4f49-bcf8-23b8704c2ffe",
                "e899c29f-8e6e-4e1d-9b14-45d30ac87e97",
                "e69cb7f7-66a1-432d-82d3-1366762cde0b",
                "3d57e981-a8ac-491d-8737-058d38f89951",
                "b74cc487-8347-426b-8e03-26876430c4ae",
                "b2a23763-7b89-423d-9c6f-ba3d204b43c2",
                "0f957127-a67d-4fe8-9589-5abc4b72a51c",
                "53101658-a1bb-4d69-aa26-875956a5d055",
                "e3015f31-a131-4529-8380-1690a7acb468",
                "b9dfe750-f9a0-4c31-af36-3842d5784c42",
                "54296c4f-3631-44cd-b414-ef28373831bf",
                "1a9331ce-d1d4-4f26-acaa-2064885e74e2",
                "099f132a-1850-4422-a142-1fecb16936f9",
                "68fe74db-343e-48fe-92bb-e18818f85327",
                "bcfc1e48-0518-4467-b84e-ab1ff4b48b2b",
                "e39d6599-81e2-447e-b5f2-bbbc8a9e2af9",
                "7773ed59-9e47-4a1e-b5de-66e9b0b555ad",
                "9eb0de14-f677-45e3-86cc-9162ebb1c015",
                "5b26a62d-7078-4259-affd-74e7b59362ca",
                "64acb1a8-4131-420c-847d-5916df8c2a3c",
                "99197b77-c338-4833-82cb-87879f59cdc4",
                "1508ec88-1392-4f1f-927e-59f1e4c0ca71",
                "5c4461d4-0dde-4bf5-9280-2173c5a119d4",
                "e3833744-afcb-492b-85a2-ba50fbc53350",
                "4422d99a-ec08-4d7e-9940-80440c3b6a68",
                "e34552e3-aa84-4f6d-9c4c-8452f52fa9f8",
                "c9e05ee9-f1c3-44c8-a166-6d1df76d46c1",
                "1dc14d02-3328-4477-ba90-60dd0141f8e7",
                "71db965a-c7de-43c5-b35c-f7abaff716be",
                "a43b79e6-6091-4a56-bb67-c261ecd0f9e9",
                "c2973465-dccd-42f6-bf56-f1d44ab50088",
                "c47490ad-b206-4b02-83c3-5e4bcd6e5154",
                "2b63f1aa-c899-41cf-b970-840a0a4d7c81"
        );
    }

    public static void createIds() {
        Stream<UUID> uuidStream = Stream.generate(UUID::randomUUID);

        // Collect the first 50 UUIDs from the stream into a List
        List<UUID> uuidList = uuidStream.limit(50).collect(Collectors.toList());

        // Print the UUIDs
        uuidList.forEach(System.out::println);
    }
}
